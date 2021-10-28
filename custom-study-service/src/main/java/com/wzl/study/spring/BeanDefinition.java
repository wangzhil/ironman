package com.wzl.study.spring;

/**
 * BeanDenifition
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 8:39
 */
public class BeanDefinition {

    private Class clazz;

    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
