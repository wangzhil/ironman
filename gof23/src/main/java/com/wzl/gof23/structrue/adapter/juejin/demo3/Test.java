package com.wzl.gof23.structrue.adapter.juejin.demo3;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:46
 */
public class Test {

    public static void main(String[] args) {

        Adaptor.builder().target(new Adaptee1()).build().request();
        Adaptor.builder().target(new Adaptee2()).build().request();

    }
}
