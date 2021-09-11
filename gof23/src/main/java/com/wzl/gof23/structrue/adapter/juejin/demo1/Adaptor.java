package com.wzl.gof23.structrue.adapter.juejin.demo1;

/**
 * 适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:19
 */
public class Adaptor extends Adaptee implements Target {

    @Override
    public void request() {
        super.adapteeRequest();
    }
}
