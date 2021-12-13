package com.wzl.mq.controller;

import common.wzl.mq.api.mq.domain.request.MqMessageRequest;
import common.wzl.mq.api.mq.service.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/10 21:55
 */
@RestController
@Slf4j
public class MqProducerController {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Resource
    private MqProducerService mqProducerService;

    @PostMapping(MqProducerService.BASE_URL_IN + "sendMQMessage")
    public String mqProducerSend(MqMessageRequest param) {
        return mqProducerService.sendMQMessage(param);
    }
}
