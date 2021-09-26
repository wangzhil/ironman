package com.wzl.share.strategy.message.controller;

import com.wzl.share.strategy.message.domain.dto.MessageDto;
import com.wzl.share.strategy.message.factory.MessageContext;
import com.wzl.share.strategy.message.factory.SendMessageContext;
import com.wzl.share.strategy.message.service.SendMessageService;
import com.wzl.share.strategy.message.service.impl.TextMessageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:24
 */
@RestController
public class TestMessageController {

    @Resource
    private SendMessageService sendMessageServiceImpl;

    @Resource
    private SendMessageContext sendMessageContext;

    @GetMapping("/sendMessage")
    public String sendMessage(@ModelAttribute MessageDto messageDto) {

        return sendMessageServiceImpl.sendMessage(messageDto);
    }


    @GetMapping("/sendMessagePlus")
    public String sendMessagePlus(@ModelAttribute MessageDto messageDto) {
        MessageContext messageContext = new MessageContext(new TextMessageServiceImpl());
        return messageContext.sendMessage(messageDto);
    }

    @GetMapping("/sendMessageSuperPlus")
    public String sendMessageSuperPlus(@ModelAttribute MessageDto messageDto) {

        return sendMessageContext.getContext(messageDto.getMessageType())
                .sendMessage(messageDto);
    }



}
