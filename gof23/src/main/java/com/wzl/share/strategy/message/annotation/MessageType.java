package com.wzl.share.strategy.message.annotation;

import com.wzl.share.strategy.message.MessageTypeEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 消息类型
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 11:18
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageType {
    MessageTypeEnum type() default MessageTypeEnum.TEXT;
}
