package com.wzl.gof23.structrue.bridge.demo.formal.try1.channel;

import com.wzl.gof23.structrue.bridge.demo.formal.try1.mode.PayMode;

import java.math.BigDecimal;

/**
 * 支付
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:04
 */
public abstract class Pay {

    public PayMode payMode;

    public Pay(PayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
