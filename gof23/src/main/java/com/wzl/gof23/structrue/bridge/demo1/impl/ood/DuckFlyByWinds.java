package com.wzl.gof23.structrue.bridge.demo1.impl.ood;

import com.wzl.gof23.structrue.bridge.demo1.DuckFly;

/**
 * 翅膀飞行
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:49
 */
public class DuckFlyByWinds implements DuckFly {
    @Override
    public void fly() {
        System.out.println("我是一只完全靠翅膀飞行的鸭子!!很强，翅膀！");
    }
}
