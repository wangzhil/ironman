package com.wzl.share.strategy.message.factory;

import com.wzl.share.strategy.message.service.SendMessageService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 封装消息bean
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 11:25
 */
@Component
public class SendMessageContext {

    public ConcurrentHashMap<String, SendMessageService> context = new ConcurrentHashMap<>();

    public void putContext(String type, SendMessageService sendMessageService) {
        context.put(type, sendMessageService);
    }

    public SendMessageService getContext(String messageType) {
        return context.get(messageType);
    }
}
