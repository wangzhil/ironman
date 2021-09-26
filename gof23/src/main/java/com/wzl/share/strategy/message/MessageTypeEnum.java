package com.wzl.share.strategy.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息类型枚举
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 10:38
 */
@Getter
@AllArgsConstructor
public enum MessageTypeEnum {

    /**
     * 消息类型
     */
    TEXT("TEXT", "文本"),
    VIDEO("VIDEO", "视频"),
    MUSIC("MUSIC", "音乐");

    public final String code;
    public final String desc;
}
