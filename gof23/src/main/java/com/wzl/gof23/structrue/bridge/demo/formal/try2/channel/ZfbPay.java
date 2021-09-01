package com.wzl.gof23.structrue.bridge.demo.formal.try2.channel;

import com.wzl.gof23.structrue.bridge.demo.formal.try2.mode.PayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 支付宝支付
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:12
 */
@Slf4j
public class ZfbPay implements Pay {


    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("支付宝支付开始...");

        return "00000";
    }
}
