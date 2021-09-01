package com.wzl.gof23.structrue.bridge.demo.formal.try2.channel;

import com.wzl.gof23.structrue.bridge.demo.formal.try2.mode.PayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 微信支付
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:11
 */
@Slf4j
public class WxPay implements Pay {

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道支付划账开始...uId:.....");

        return "0000";
    }
}
