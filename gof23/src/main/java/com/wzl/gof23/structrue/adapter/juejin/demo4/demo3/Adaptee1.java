package com.wzl.gof23.structrue.adapter.juejin.demo4.demo3;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:58
 */
public class Adaptee1 extends AdapteeParent {

    @Override
    public void request() {
        System.out.println("这是adaptee1的request方法");
    }
}
