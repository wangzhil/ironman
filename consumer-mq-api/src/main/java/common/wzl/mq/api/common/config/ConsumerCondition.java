package common.wzl.mq.api.common.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * 消费端Condition
 *
 * @author dzz
 * @version 1.0.0
 * @since 2020年07月07 下午3:56
 */
@Slf4j
@Data
@Component
public class ConsumerCondition implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();
        String topics = environment.getProperty("kafka.topics");

        return !StringUtils.isBlank(topics);
    }
}
