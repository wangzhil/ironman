package com.wzl.gof23.structrue.adapter.juejin.demo2;

/**
 * 被适配者2号
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:29
 */
public class Adaptee2 implements Source {


    @Override
    public void adapteeRequest() {
        System.out.println("被适配者2号");
    }
}
