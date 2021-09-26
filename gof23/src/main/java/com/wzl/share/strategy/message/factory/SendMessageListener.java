package com.wzl.share.strategy.message.factory;

import com.wzl.share.strategy.message.annotation.MessageType;
import com.wzl.share.strategy.message.service.SendMessageService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息类型启动监听
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 11:13
 */
@Component
public class SendMessageListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MessageType.class);
        final SendMessageContext context = event.getApplicationContext().getBean(SendMessageContext.class);
        beans.forEach((key, bean) -> {
            final MessageType annotation = bean.getClass().getAnnotation(MessageType.class);
            context.putContext(annotation.type().getCode(), (SendMessageService) bean);
        });
    }
}
