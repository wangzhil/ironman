package com.wzl.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MQ启动
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/10 21:45
 */
@SpringBootApplication(scanBasePackages = {"common.wzl.mq.api", "com.wzl"})
public class MqServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqServiceApplication.class, args);
    }
}
