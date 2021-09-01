package com.wzl.gof23.structrue.bridge.demo.formal.try2;

import com.wzl.gof23.structrue.bridge.demo.formal.try2.channel.PayAdaptor;
import com.wzl.gof23.structrue.bridge.demo.formal.try2.channel.WxPay;
import com.wzl.gof23.structrue.bridge.demo.formal.try2.mode.FingerPrint;

import java.math.BigDecimal;

/**
 * 测试2，模拟适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/1 8:53
 */
public class FormalTest2 {

    public static void main(String[] args) {
        FingerPrint fingerPrint = new FingerPrint();
        new PayAdaptor(new WxPay()).transfer("111", "11112", new BigDecimal("231"));
    }
}
