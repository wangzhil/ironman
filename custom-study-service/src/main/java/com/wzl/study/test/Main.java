package com.wzl.study.test;

import com.wzl.study.newspring.WangZhiLeiContext;
import com.wzl.study.test.service.AppConfig;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/1 8:18
 */
public class Main {

    public static void main(String[] args) {
        WangZhiLeiContext context = new WangZhiLeiContext(AppConfig.class);
        context.get("appService");
    }
}
