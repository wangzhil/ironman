package common.wzl.mq.api.mq.service;

/**
 * 消费端接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2020年07月06 下午4:44
 */
public interface MqConsumerService {

    /**
     * 消息消费处理方法
     * @param message 消息内容
     */
    void consumer(String message);

    /**
     * 消息主题，确定消费指定主题
     * @return 主题
     */
    String getTopic();
}
