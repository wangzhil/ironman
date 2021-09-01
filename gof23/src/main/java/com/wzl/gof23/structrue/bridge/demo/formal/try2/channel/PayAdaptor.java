package com.wzl.gof23.structrue.bridge.demo.formal.try2.channel;

import java.math.BigDecimal;

/**
 * 支付适配
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:42
 */
public class PayAdaptor implements Pay {

    private Pay pay;

    public PayAdaptor(Pay pay) {
        this.pay = pay;
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        return pay.transfer(uId, tradeId, amount);
    }
}
