package com.wzl.share.strategy.message.factory;

import com.wzl.share.strategy.message.domain.dto.MessageDto;
import com.wzl.share.strategy.message.service.SendMessageService;

/**
 * 消息上下文
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:56
 */
public class MessageContext {

    public SendMessageService sendMessageService;

    public MessageContext(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    /**
     * 发送消息
     *
     * @param messageDto 消息dto
     * @return {@link String}
     */
    public String sendMessage(MessageDto messageDto) {
        return sendMessageService.sendMessage(messageDto);
    }


}
