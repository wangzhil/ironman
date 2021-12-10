package common.wzl.mq.api.mq.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * MQ消息发送请求参数
 *
 * @author dzz
 * @version 1.0.0
 * @since 2020年07月06 下午1:38
 */
@Data
public class MqMessageRequest implements Serializable {

    private static final long serialVersionUID = 5844252194034526010L;

    /**
     * 分组ID
     */
    private String groupId;

    /**
     * 主题
     */
    private String topic;

    /**
     * 消息
     */
    private String message;

}
