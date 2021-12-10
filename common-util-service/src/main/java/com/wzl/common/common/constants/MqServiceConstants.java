package com.wzl.common.common.constants;

/**
 * 消息路径
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/9 22:35
 */
public interface MqServiceConstants {

    /**
     * 服务名称
     */
    String SERVICE_NAME = "bzn-mq-service";

    /**
     * 外部请求地址前缀
     */
    String OUT_SERVICE_PATH = "/mq/api/out/";


    /**
     * 内部请求地址前缀
     */
    String IN_SERVICE_PATH = "/mq/api/in/";
}
