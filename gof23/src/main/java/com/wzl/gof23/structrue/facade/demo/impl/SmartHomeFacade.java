package com.wzl.gof23.structrue.facade.demo.impl;

/**
 * 智能家居外观模式类
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 9:17
 */
public class SmartHomeFacade {

    private Light light;

    private Tv tv;

    private AirCondition airCondition;

    SmartHomeFacade() {
        light = new Light();
        tv = new Tv();
        airCondition = new AirCondition();
    }

    void say(String message) {
        if ("开启智能家居".equals(message)) {
            smartOn();
        } else if ("关闭智能家居".equals(message)) {
            smartOff();
        } else {
            System.out.println("有问题,听不懂!");
        }
    }

    private void smartOn() {
        light.smartOn();
        tv.smartOn();
        airCondition.smartOn();
    }

    private void smartOff() {
        light.smartOff();
        tv.smartOff();
        airCondition.smartOff();
    }
}
