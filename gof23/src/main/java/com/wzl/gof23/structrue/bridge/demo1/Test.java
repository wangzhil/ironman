package com.wzl.gof23.structrue.bridge.demo1;

import com.wzl.gof23.structrue.bridge.demo1.impl.oo.GreenHeadDuck;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 12:01
 */
public class Test {

    public static void main(String[] args) {
        Duck duck = new GreenHeadDuck();
        duck.display();
        duck.fly();
    }
}
