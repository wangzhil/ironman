package com.wzl.study.wang.config;

import com.wzl.study.spring.BeanPostProcessor;
import com.wzl.study.spring.Component;
import org.springframework.beans.BeansException;

import java.lang.reflect.Proxy;

/**
 * 后置处理器实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/29 7:40
 */
@Component("zhiLeiBeanPostProcessor")
public class ZhiLeiBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            System.out.println("初始化前");
            ((UserServiceImpl) bean).setBeanName("我好帅好帅");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后");
        if (beanName.equals("userService")) {

            Proxy.newProxyInstance(
                    ZhiLeiBeanPostProcessor.class.getClassLoader(),
                    bean.getClass().getInterfaces(), (proxy, method, args) -> {
                        System.out.println("代理逻辑前");
                        Object obj = method.invoke(bean, args);
                        System.out.println("代理逻辑后");
                        return obj;
                    });
        }
        return bean;
    }
}
