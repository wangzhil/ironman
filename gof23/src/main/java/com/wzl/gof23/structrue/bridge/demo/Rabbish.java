package com.wzl.gof23.structrue.bridge.demo;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 垃圾
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/8/31 9:18
 */
@Slf4j
public class Rabbish {

    /**
     * 支付
     * @param uId
     * @param tradeId
     * @param amount
     * @param channelType
     * @param modeType
     * @return
     */
    public boolean pay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // 微信
        if (1 == channelType) {
            log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        } else if (2 == channelType) {
            log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }
}
