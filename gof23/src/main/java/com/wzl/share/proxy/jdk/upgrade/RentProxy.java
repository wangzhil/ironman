package com.wzl.share.proxy.jdk.upgrade;

import java.lang.reflect.Proxy;

/**
 * Rent代理
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 9:35
 */
public class RentProxy {

    private Object object;

    RentProxy(Object obj) {
        this.object = obj;
    }

    Object getRentProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), ((proxy, method, args) -> {
            System.out.println("前...");
            Object objct = method.invoke(object, args);
            System.out.println("后...");
            return objct;
        }));
    }
}
