package com.wzl.gof23.structrue.adapter.juejin.demo2;

/**
 * 适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
public class Adaptor implements Target {

    private Source source;

    public Adaptor(Source source) {
        this.source = source;
    }

    @Override
    public void request() {
        source.adapteeRequest();
    }
}
