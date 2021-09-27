package com.wzl.share.proxy.jdk.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Jdk的动态代理InvocationHandler实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 13:51
 */
public class JdkInvocationHandler implements InvocationHandler {

    private Object object;

    JdkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logBefore();
        Object obj = method.invoke(object, args);
        logAfter();
        return obj;
    }

    void logBefore() {
        System.out.println("before切面前............");
    }

    void logAfter() {
        System.out.println("after切面后.............");
    }
}
