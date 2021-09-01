package com.wzl.gof23.structrue.bridge.demo.formal.try1.channel;

import com.wzl.gof23.structrue.bridge.demo.formal.try1.mode.PayMode;
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
public class ZfbPay extends Pay {

    public ZfbPay(PayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("支付宝支付开始...");
        boolean security = payMode.security(uId);
        if (!security) {
            log.info("支付风控校验失败!");
            return "00001";
        }
        return "00000";
    }
}
