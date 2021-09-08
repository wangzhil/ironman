package com.wzl.gof23.structrue.facade.demo.impl;

import com.wzl.gof23.structrue.facade.demo.SmartHome;

/**
 * 电灯
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 9:11
 */
public class Light implements SmartHome {

    @Override
    public void smartOn() {
        System.out.println("灯光智能打开");
    }

    @Override
    public void smartOff() {
        System.out.println("灯光智能打开");
    }
}
