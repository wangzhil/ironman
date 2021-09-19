package com.wzl.gof23.structrue.bridge.demo1.impl.ood;

import com.wzl.gof23.structrue.bridge.demo1.DuckFly;

/**
 * 不会飞的鸭子
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:50
 */
public class DuckCanNotFly implements DuckFly {
    @Override
    public void fly() {
        System.out.println("我是一只不会飞的鸭子!!!!!");
    }
}
