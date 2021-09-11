package com.wzl.gof23.structrue.adapter.juejin.demo5;

/**
 * 被适配者
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
public class Adaptee1 extends AdapteeParent {
    @Override
    public void request1() {
        System.out.println("Adaptee1 的 request1");
    }
}
