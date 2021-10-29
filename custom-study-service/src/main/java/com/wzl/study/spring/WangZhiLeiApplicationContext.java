package com.wzl.study.spring;

import org.springframework.beans.factory.InitializingBean;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义Spring
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 7:38
 */
public class WangZhiLeiApplicationContext {

    private Class configClass;

    /**
     * 单例对象
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();



    public WangZhiLeiApplicationContext(Class<?> config) {
        this.configClass = config;

        scan();

        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            } else {

            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        final Class<?> clazz = beanDefinition.getClazz();
        Object instance = null;
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            instance = constructor.newInstance();
            // 完成依赖注入
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    final Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }
            // Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 初始化
            if (instance instanceof ZhiLeiInitializingBean) {
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }

            constructor.setAccessible(false);


        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private void scan() {
        final ComponentScan annotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = annotation.value();
        path = path.replace(".", "/");
        ClassLoader classLoader = WangZhiLeiApplicationContext.class.getClassLoader();
        // 加载路径下的文件
        final URL resource = classLoader.getResource(path);
        final File file = new File(resource.getFile());
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                String name = f.getAbsolutePath();
                System.out.println(name);
                String className = name.substring(name.indexOf("com"), name.indexOf(".class"));
                className = className.replace(File.separator, ".");

                try {
                    final Class<?> clazz = classLoader.loadClass(className);
                    if (clazz.isAnnotationPresent(Component.class)) {

                        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                            BeanPostProcessor beanPostProcessor = (BeanPostProcessor) clazz.getConstructor().newInstance();
                            beanPostProcessors.add(beanPostProcessor);
                        }

                        final Component declaredAnnotation = clazz.getDeclaredAnnotation(Component.class);
                        final String beanName = declaredAnnotation.value();
                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setClazz(clazz);
                        if (clazz.isAnnotationPresent(Scope.class)) {
                            Scope scope = clazz.getDeclaredAnnotation(Scope.class);
                            beanDefinition.setScope(scope.value());
                        } else {
                            beanDefinition.setScope("singleton");
                        }
                        beanDefinitionMap.put(beanName, beanDefinition);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjects.get(beanName);
            } else {
                // 不为原型的则创建一个对象。
                return createBean(beanName, beanDefinition);
            }
        }
        return null;
    }
}
