package com.wzl.gof23.structrue.bridge.demo.formal.try2.mode;

/**
 * 支付方式
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/8/31 9:35
 */
public interface PayMode {

    boolean security(String uid);
}
