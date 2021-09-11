package com.wzl.gof23.structrue.adapter.juejin.demo5;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 11:29
 */
public abstract class AdapteeParent implements Source {

    @Override
    public void request1() {
        System.out.println("默认!待重写!");
    }
}
