package com.wzl.gof23.structrue.proxy.dynamic.jdk;

import com.wzl.gof23.structrue.proxy.dynamic.statici.HomeOwner;
import com.wzl.gof23.structrue.proxy.dynamic.statici.Rent;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理Test  使用lambda的方式实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 15:40
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        Rent homeOwner = new HomeOwner();
        Object o = Proxy.newProxyInstance(homeOwner.getClass().getClassLoader(), homeOwner.getClass().getInterfaces(), (proxy, method, ags) -> {
            System.out.println("before");
            Object obj = method.invoke(homeOwner, ags);
            System.out.println("after");
            return obj;
        });
        ((Rent) o).rent();
    }
}
