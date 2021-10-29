package com.wzl.study.spring;

import org.springframework.beans.BeansException;

/**
 * bean的后置处理器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/29 7:38
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
