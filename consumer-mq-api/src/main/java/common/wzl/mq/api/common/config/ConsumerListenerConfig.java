package common.wzl.mq.api.common.config;

import com.bzn.mq.api.mq.service.MqConsumerService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * Consumer 配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2020年07月07 下午2:01
 */
@Configuration
@Slf4j
@Data
@DependsOn("mQConsumerConfig")
@Conditional(ConsumerCondition.class)
public class ConsumerListenerConfig {

    @Autowired(required = false)
    private List<MqConsumerService> mqConsumerServiceList;


    @KafkaListener(topics={"#{'${kafka.topics}'.split(',')}"})
    private void listen(ConsumerRecord<String,String> data) {
        log.info("接收到的数据为:{}",data);
        String topic = data.topic();
        if(CollectionUtils.isEmpty(mqConsumerServiceList)) {
            log.error("未找到topic为 {} 的接口实现，未能完成消费,消息内容为 {}", topic,data.value());
            return;
        }
        Optional<MqConsumerService> optional = mqConsumerServiceList.stream()
                .filter(i -> i.getTopic().equalsIgnoreCase(topic)).findFirst();
        if(optional.isPresent()) {
            optional.get().consumer(data.value());
        }else{
            log.error("未找到topic为 {} 的接口实现，未能完成消费,消息内容为 {}", topic,data.value());
        }
    }

}
