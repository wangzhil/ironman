package com.wzl.gof23.structrue.bridge.demo.formal.try2.channel;

import java.math.BigDecimal;

/**
 * 支付
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:04
 */
public interface Pay {

    String transfer(String uId, String tradeId, BigDecimal amount);
}
