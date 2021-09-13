package com.wzl.headfirst.phase1;

/**
 * 超级父类
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/13 8:59
 */
public abstract class Duck {

    public void quack() {
        System.out.println("鸭子嘎嘎嘎!");
    }

    public void swim() {
        System.out.println("鸭子游泳!");
    }

    public void fly() {
        System.out.println("鸭子起飞了!!!");
    }

    public abstract void display();
}
