package com.wzl.gof23.structrue.bridge.demo.formal.try1;

import com.wzl.gof23.structrue.bridge.demo.formal.try1.channel.WxPay;
import com.wzl.gof23.structrue.bridge.demo.formal.try1.mode.FingerPrint;

import java.math.BigDecimal;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:29
 */
public class FormalTest {

    public static void main(String[] args) {
        new WxPay(new FingerPrint()).transfer("0001", "Id", new BigDecimal(1111));
    }
}
