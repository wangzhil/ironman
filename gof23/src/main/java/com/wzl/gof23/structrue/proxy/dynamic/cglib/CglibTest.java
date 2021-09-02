package com.wzl.gof23.structrue.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * CglibTest
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 14:34
 */
public class CglibTest {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HomeOwner.class);
        enhancer.setCallback(cglibProxy);
        HomeOwner homeOwner = (HomeOwner) enhancer.create();
        homeOwner.rent();
       /* Class<? extends HomeOwner> baseClass = homeOwner.getClass();
        // 查看增强过的类的父类是不是未增强的Base类
        System.out.println("增强过的类的父类：" + baseClass.getSuperclass().getName());
        System.out.println("============打印增强过的类的所有方法==============");
        FanSheUtils.printMethods(baseClass);

        //没有被增强过的base类
        HomeOwner base2 = new HomeOwner();
        System.out.println("未增强过的类的父类：" + base2.getClass().getSuperclass().getName());
        System.out.println("=============打印增未强过的目标类的方法===============");
        // 打印没有增强过的类的所有方法
        FanSheUtils.printMethods(base2.getClass());*/

    }
}
