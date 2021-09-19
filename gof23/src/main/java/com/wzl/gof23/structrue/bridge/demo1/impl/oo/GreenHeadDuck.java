package com.wzl.gof23.structrue.bridge.demo1.impl.oo;

import com.wzl.gof23.structrue.bridge.demo1.Duck;
import com.wzl.gof23.structrue.bridge.demo1.impl.ood.DefaultDuckFly;

/**
 * 绿头鸭
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:42
 */
public class GreenHeadDuck extends Duck {

    public GreenHeadDuck() {
        this.duckFly = new DefaultDuckFly();
    }

    @Override
    public void display() {
        System.out.println("我是一只绿头鸭子!!!!");
    }

}
