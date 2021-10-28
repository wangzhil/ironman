package com.wzl.study.spring;

import java.io.File;
import java.net.URL;
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

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> beanDefinitionMap = new ConcurrentHashMap<>();


    public WangZhiLeiApplicationContext(Class<?> config) {
        this.configClass = config;

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
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            return beanDefinitionMap.get(beanName);
        }
        return null;
    }
}
