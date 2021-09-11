package com.wzl.gof23.structrue.adapter.juejin.demo5;

import com.wzl.gof23.structrue.adapter.juejin.demo4.demo3.Adaptee1;
import com.wzl.gof23.structrue.adapter.juejin.demo4.demo3.Adaptor;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:46
 */
public class Test {

    public static void main(String[] args) {

        new Adaptor(new Adaptee1()).request1();
    }
}
