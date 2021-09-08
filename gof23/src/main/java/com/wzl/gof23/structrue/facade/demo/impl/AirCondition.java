package com.wzl.gof23.structrue.facade.demo.impl;

import com.wzl.gof23.structrue.facade.demo.SmartHome;

/**
 * 空调
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 9:15
 */
public class AirCondition implements SmartHome {

    @Override
    public void smartOn() {
        System.out.println("空调智能开启");
    }

    @Override
    public void smartOff() {
        System.out.println("空调智能关闭");
    }
}
