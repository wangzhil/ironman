package com.wzl.share.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxy代理
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 14:30
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logBefore();
        methodProxy.invokeSuper(obj, objects);
        logAfter();
        return null;
    }

    void logBefore() {
        System.out.println("before切面前............");
    }

    void logAfter() {
        System.out.println("after切面后.............");
    }


    /**
     * 初始化代理
     *
     * @param clazz clazz
     * @return {@link Object}
     */
    public static Object initProxy(Class clazz) {
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(cglibProxy);
        return enhancer.create();
    }
}
