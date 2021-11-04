package com.wzl.study.newspring;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/2 20:22
 */
public class BeanDefinition {

    private Class<?> clazz;

    private String scope;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
