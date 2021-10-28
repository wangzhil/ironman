package com.wzl.study.wang;

import com.wzl.study.spring.WangZhiLeiApplicationContext;
import com.wzl.study.wang.config.AppConfig;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 7:52
 */
public class Test {

    public static void main(String[] args) {
        WangZhiLeiApplicationContext context = new WangZhiLeiApplicationContext(AppConfig.class);
        final Object userService = context.getBean("userService");
        System.out.println(userService);

    }
}
