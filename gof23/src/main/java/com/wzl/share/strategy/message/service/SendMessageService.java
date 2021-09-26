package com.wzl.share.strategy.message.service;

import com.wzl.share.strategy.message.domain.dto.MessageDto;

/**
 * 消息发送
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:35
 */
public interface SendMessageService {


    /**
     * 发送消息
     *
     * @param messageDto 消息dto
     * @return {@link String}
     */
    String sendMessage(MessageDto messageDto);
}
