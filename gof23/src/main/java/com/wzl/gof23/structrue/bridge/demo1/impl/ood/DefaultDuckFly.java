package com.wzl.gof23.structrue.bridge.demo1.impl.ood;

import com.wzl.gof23.structrue.bridge.demo1.DuckFly;

/**
 * 默认的飞行行为
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:48
 */
public class DefaultDuckFly implements DuckFly {
    @Override
    public void fly() {
        System.out.println("我是一只鸭子，我本身就会飞!");
    }
}
