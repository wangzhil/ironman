package com.wzl.gof23.structrue.bridge.demo1;

/**
 * 鸭子鼻主
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 11:38
 */
public abstract class Duck implements DuckFly {

    public DuckFly duckFly;

    public void setDuckFly(DuckFly duckFly) {
        this.duckFly = duckFly;
    }

    @Override
    public void fly() {
        this.duckFly.fly();
    }

    public void quack() {
        System.out.println("默认鸭子叫...");
    }
    public void swim() {
        System.out.println("鸭子会游泳.....");
    }

    /**
     * 描述自己是啥子鸭子
     */
    public abstract void display();
}
