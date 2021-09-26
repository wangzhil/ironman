package com.wzl.share.strategy.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzl.share.strategy.message.MessageTypeEnum;
import com.wzl.share.strategy.message.annotation.MessageType;
import com.wzl.share.strategy.message.domain.dto.MessageDto;
import com.wzl.share.strategy.message.service.SendMessageService;
import org.springframework.stereotype.Service;

/**
 * 文本实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:57
 */
@MessageType(type = MessageTypeEnum.TEXT)
@Service
public class TextMessageServiceImpl implements SendMessageService {

    @Override
    public String sendMessage(MessageDto messageDto) {
        return "文本消息: " + JSONObject.toJSONString(messageDto);
    }
}
