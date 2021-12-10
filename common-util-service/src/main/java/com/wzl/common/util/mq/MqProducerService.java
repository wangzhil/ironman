package com.wzl.common.util.mq;

import com.wzl.common.common.constants.MqServiceConstants;
import com.wzl.common.common.feign.MqServiceFeignConfig;
import com.wzl.common.util.mq.domian.request.MqMessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * kafka生产者
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/9 22:32
 */
@FeignClient(name = MqServiceConstants.SERVICE_NAME, decode404 = true, configuration = MqServiceFeignConfig.class)
public interface MqProducerService {

    /**
     * 内部请求路径
     */
    String BASE_URL_IN = MqServiceConstants.IN_SERVICE_PATH;

    /**
     * 外部请求路径
     */
    String BASE_URL_OUT = MqServiceConstants.OUT_SERVICE_PATH;

    /**
     * 消息发送接口
     * @param param 请求参数
     * @return 发送结果
     */
    @PostMapping(BASE_URL_IN + "sendMQMessage")
    String sendMQMessage(@RequestBody MqMessageRequest param);
}
