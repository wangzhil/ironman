package com.wzl.share.strategy.message.domain.dto;

import lombok.Data;

/**
 * 消息
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:26
 */
@Data
public class MessageDto {

    /**
     * 消息
     */
    private String message;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 来自谁
     */
    private String fromUser;

    /**
     * 发给谁
     */
    private String toUser;

    /**
     * 文件路径
     */
    private String filePath;
}
