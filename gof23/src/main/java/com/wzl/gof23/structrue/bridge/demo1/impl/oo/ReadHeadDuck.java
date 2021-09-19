package com.wzl.gof23.structrue.bridge.demo1.impl.oo;

import com.wzl.gof23.structrue.bridge.demo1.Duck;
import com.wzl.gof23.structrue.bridge.demo1.impl.ood.DuckFlyByWinds;

/**
 * 红头鸭
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:43
 */
public class ReadHeadDuck extends Duck {

    public ReadHeadDuck() {
        this.duckFly = new DuckFlyByWinds();
    }

    @Override
    public void display() {
        System.out.println("我是一只红头鸭!!!!!");
    }

}
