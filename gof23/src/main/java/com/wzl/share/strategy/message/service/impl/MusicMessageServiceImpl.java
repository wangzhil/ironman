package com.wzl.share.strategy.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wzl.share.strategy.message.MessageTypeEnum;
import com.wzl.share.strategy.message.annotation.MessageType;
import com.wzl.share.strategy.message.domain.dto.MessageDto;
import com.wzl.share.strategy.message.service.SendMessageService;
import org.springframework.stereotype.Service;

/**
 * 音乐实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:57
 */
@MessageType(type = MessageTypeEnum.MUSIC)
@Service
public class MusicMessageServiceImpl implements SendMessageService {

    @Override
    public String sendMessage(MessageDto messageDto) {
        return "视频消息: " + JSONObject.toJSONString(messageDto);
    }
}
