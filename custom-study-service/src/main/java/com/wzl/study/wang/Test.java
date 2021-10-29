package com.wzl.study.wang;

import com.wzl.study.spring.WangZhiLeiApplicationContext;
import com.wzl.study.wang.config.AppConfig;
import com.wzl.study.wang.config.UserService;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 7:52
 */
public class Test {

    public static void main(String[] args) {
        WangZhiLeiApplicationContext context = new WangZhiLeiApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();

    }
}
