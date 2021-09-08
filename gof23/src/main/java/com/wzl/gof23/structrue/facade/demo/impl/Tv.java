package com.wzl.gof23.structrue.facade.demo.impl;

import com.wzl.gof23.structrue.facade.demo.SmartHome;

/**
 * 电视
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 9:12
 */
public class Tv implements SmartHome {
    @Override
    public void smartOn() {
        System.out.println("智能电视打开");
    }

    @Override
    public void smartOff() {
        System.out.println("智能电视关闭");
    }
}
