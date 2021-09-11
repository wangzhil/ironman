package com.wzl.gof23.structrue.adapter.juejin.demo4.demo3;

/**
 * 适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
public class Adaptor1 extends AdaptorParent {

    public Adaptor1(Target target) {
        this.target = target;
    }

    @Override
    public void request1() {
        super.request1();
    }
}
