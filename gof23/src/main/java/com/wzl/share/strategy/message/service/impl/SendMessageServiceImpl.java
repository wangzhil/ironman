package com.wzl.share.strategy.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzl.share.strategy.message.MessageTypeEnum;
import com.wzl.share.strategy.message.domain.dto.MessageDto;
import com.wzl.share.strategy.message.service.SendMessageService;
import org.springframework.stereotype.Service;

/**
 * 消息发送实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:46
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Override
    public String sendMessage(MessageDto messageDto) {

        if (MessageTypeEnum.TEXT.getCode().equals(messageDto.getMessageType())) {
            return "文本消息: " + JSONObject.toJSONString(messageDto);
        } else if (MessageTypeEnum.VIDEO.getCode().equals(messageDto.getMessageType())) {
            return "视频消息: " + JSONObject.toJSONString(messageDto);
        } else if (MessageTypeEnum.MUSIC.getCode().equals(messageDto.getMessageType())) {
            return "音乐消息:" + JSONObject.toJSONString(messageDto);
        }
        return null;
    }
}
