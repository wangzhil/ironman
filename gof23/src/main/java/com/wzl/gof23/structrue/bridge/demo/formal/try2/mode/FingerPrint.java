package com.wzl.gof23.structrue.bridge.demo.formal.try2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 指纹识别
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:02
 */
@Slf4j
public class FingerPrint implements PayMode {
    @Override
    public boolean security(String uid) {
        log.info("指纹支付,风控校验环境!");
        return true;
    }
}
