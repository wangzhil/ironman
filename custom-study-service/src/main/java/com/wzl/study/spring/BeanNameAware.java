package com.wzl.study.spring;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 22:15
 */
public interface BeanNameAware {

    /**
     * 设置bean名称
     *
     * @param name 的名字
     */
    void setBeanName(String name);
}
