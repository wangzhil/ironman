package com.wzl.gof23.structrue.adapter.juejin.demo2;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:42
 */
public class Test {

    public static void main(String[] args) {
        new Adaptor(new Adaptee2()).request();
        new Adaptor(new Adaptee1()).request();
    }
}
