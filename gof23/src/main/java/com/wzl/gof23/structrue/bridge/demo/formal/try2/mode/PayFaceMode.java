package com.wzl.gof23.structrue.bridge.demo.formal.try2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 人脸识别
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/8/31 9:40
 */
@Slf4j
public class PayFaceMode implements PayMode {
    @Override
    public boolean security(String uid) {
        log.info("人脸识别,风控校验环境安全!");
        return true;
    }
}
