package com.wzl.gof23.structrue.bridge.demo.formal.try1.mode;

/**
 * 支付方式
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:58
 */
public interface PayMode {
    boolean security(String uid);
}
