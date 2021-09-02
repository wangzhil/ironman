package com.wzl.gof23.structrue.proxy.dynamic.jdk;

import com.wzl.gof23.structrue.proxy.dynamic.statici.HomeOwner;
import com.wzl.gof23.structrue.proxy.dynamic.statici.Rent;

import java.lang.reflect.Proxy;


/**
 * JDK动态代理
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 13:48
 */
public class JdkProxy {

    public Object getProxy(Object obj) {
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), jdkInvocationHandler);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        final Object proxy = jdkProxy.getProxy(new HomeOwner());
        if (proxy instanceof Rent) {
            Rent owner = (Rent) proxy;
            owner.rent();
        }
    }
}
