package com.wzl.study.wang.config;

import com.wzl.study.spring.BeanPostProcessor;
import com.wzl.study.spring.Component;
import org.springframework.beans.BeansException;

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
        System.out.println("初始化前");
        if ("userService".equals(beanName)) {
            ((UserService) bean).setBeanName("我好帅好帅");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后");
        return bean;
    }
}
