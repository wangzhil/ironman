package com.wzl.gof23.structrue.adapter.juejin.demo4.demo3;

/**
 * 适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
public abstract class AdaptorParent implements Target {

    public Target target;

    @Override
    public void request() {
        target.request();
    }

    @Override
    public void request1() {
        target.request1();
    }
}
