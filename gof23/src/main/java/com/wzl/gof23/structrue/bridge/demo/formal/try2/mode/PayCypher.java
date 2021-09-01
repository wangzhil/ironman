package com.wzl.gof23.structrue.bridge.demo.formal.try2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 密码支付
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/8/31 9:38
 */
@Slf4j
public class PayCypher implements PayMode {
    @Override
    public boolean security(String uid) {
        log.info("密码支付,风控校验环境!");
        return true;
    }
}
