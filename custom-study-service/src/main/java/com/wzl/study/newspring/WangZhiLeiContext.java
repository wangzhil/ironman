package com.wzl.study.newspring;

import com.wzl.study.spring.Autowired;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/1 8:38
 */
public class WangZhiLeiContext {

    private Class<?> clazz;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();


    public WangZhiLeiContext(Class<?> clazz) {
        this.clazz = clazz;
        // 扫描启动， 给beanDefinition赋值属性
        scan(clazz);
        //
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                final Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }




    }

    private void scan(Class<?> clazz) {
        if (clazz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = clazz.getDeclaredAnnotation(ComponentScan.class);
            String scanPath = componentScan.value();
            scanPath = scanPath.replace(".", "//");
            final ClassLoader classLoader = WangZhiLeiContext.class.getClassLoader();
            final URL systemResource = classLoader.getResource(scanPath);
            assert systemResource != null;
            File file = new File(systemResource.getFile());
            if (file.isDirectory()) {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {

                    String absolutePath = listFile.getAbsolutePath();
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    String className = absolutePath.replace(File.separator, ".");
                    try {
                        Class<?> cl = classLoader.loadClass(className);
                        // 如果是component
                        if (cl.isAnnotationPresent(Component.class)) {
                            final Component component = cl.getDeclaredAnnotation(Component.class);
                            String beanName = component.value();
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(cl);
                            if (cl.isAnnotationPresent(Scope.class)) {
                                final Scope declaredAnnotation = cl.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(declaredAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = null;
        if (beanDefinitionMap.containsKey(beanName)) {
            return singletonObjects.get(beanName);
        }
        return null;

    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> cl = beanDefinition.getClazz();
        try {
            Constructor<?> beanConstructor = cl.getDeclaredConstructor();
            Object instance = beanConstructor.newInstance();
            // 完成依赖注入
            for (Field f : cl.getDeclaredFields()) {
                if (f.isAnnotationPresent(Autowired.class)) {
                    Object bean = getBean(f.getName());
                    f.setAccessible(true);
                    f.set(instance, bean);
                }
            }
            // 回调 processor
            // Aware回调，初始化

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
