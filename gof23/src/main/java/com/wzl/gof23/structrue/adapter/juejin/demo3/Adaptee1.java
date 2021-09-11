package com.wzl.gof23.structrue.adapter.juejin.demo3;

/**
 * 被适配者
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
public class Adaptee1 implements Target {
    @Override
    public void request() {
        System.out.println("目标源1号!");
    }
}
