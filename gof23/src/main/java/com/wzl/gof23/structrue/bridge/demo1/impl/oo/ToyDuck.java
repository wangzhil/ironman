package com.wzl.gof23.structrue.bridge.demo1.impl.oo;

import com.wzl.gof23.structrue.bridge.demo1.Duck;

/**
 * 玩具鸭子
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:54
 */
public class ToyDuck extends Duck {


    @Override
    public void display() {
        System.out.println("我是一只玩具鸭子!!!");
    }

}
