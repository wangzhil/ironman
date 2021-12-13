package com.wzl.mq.service;

import common.wzl.mq.api.mq.domain.request.MqMessageRequest;
import common.wzl.mq.api.mq.service.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * 消息发送
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/10 18:15
 */
@Service
@Slf4j
public class MqProducerServiceImpl implements MqProducerService {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public String sendMQMessage(MqMessageRequest param) {

        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(param.getTopic(), param.getMessage());
        future.addCallback(success -> {
            log.info("发送主题为{}的kafka消息，发送结果：成功",param.getTopic());
        }, throwable -> {
            log.info("发送主题为{}的kafka消息，发送结果：失败",param.getTopic());
        });
        return "ok";
    }
}
