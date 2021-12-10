package common.wzl.mq.api.mq.service;

import com.bzn.mq.api.common.constants.MqServiceConstants;
import com.bzn.mq.api.common.feign.MqServiceFeignConfig;
import com.bzn.mq.api.mq.domain.request.MqMessageRequest;
import com.bzn.util.response.ResponseBzn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * MQ消息接口服务
 * @author dzz
 * @version 1.0.0
 * @since 2020/7/6
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
    @PostMapping(BASE_URL_IN+"sendMQMessage")
    ResponseBzn<String> sendMQMessage(@RequestBody MqMessageRequest param);
}
