package common.wzl.mq.api.common.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * 消费端配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2020年07月06 下午4:44
 */
@Configuration("mQConsumerConfig")
@Slf4j
@Data
public class MqConsumerConfig {


    private ResourceLoader resourceLoader;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    /**
     * kafka服务地址
     */
    private String serversUrl;

    /**
     * 组ID
     */
    private String groupId;

    /**
     * 自动提交频率
     */
    private String autoCommitInterval;


    private String autoOffsetReset;


    private String enableAutoCommit;

    /**
     * 消费者订阅的主题
     */
    @Value("${kafka.topics:''}")
    private String topics;


    public MqConsumerConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 初始化配置文件
     */
    @PostConstruct
    public void init() {

        try (InputStream inputStream = resourceLoader.getResource("classpath:mq_config.properties").getInputStream()) {
            Properties properties = new Properties();
            properties.load(inputStream);
            log.info("目前应用运行环境为：{}", activeProfile);
            switch (activeProfile) {
                case "local":
                case "dev":
                    serversUrl = properties.getProperty("dev.spring.kafka.bootstrap-servers");
                    break;
                case "test":
                    serversUrl = properties.getProperty("test.spring.kafka.bootstrap-servers");
                    break;
                case "prod":
                    serversUrl = properties.getProperty("prod.spring.kafka.bootstrap-servers");
                    break;
                default:
                    log.error("未指定active.profile,将使用开发环境Kafka服务地址。");
                    serversUrl = properties.getProperty("dev.spring.kafka.bootstrap-servers");
            }
            groupId = properties.getProperty("kafka.consumer.group-id");
            autoCommitInterval = properties.getProperty("kafka.consumer.auto-commit-interval");
            autoOffsetReset = properties.getProperty("kafka.consumer.auto-offset-reset");
            enableAutoCommit = properties.getProperty("kafka.consumer.enable-auto-commit");
        } catch (Exception ex) {
            log.error("MQ客户端初始化文件异常", ex);
        }
    }

    /**
     * ConsumerFactory
     * @return ConsumerFactory
     */
    @Bean
    public ConsumerFactory<Object, Object> consumerFactory(){
        log.info("构建ConsumerFactory");
        //参数
        Map<String, Object> configs = new HashMap<>();
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.getServersUrl());
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, this.getGroupId());
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, this.getEnableAutoCommit());
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, this.getAutoCommitInterval());
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, this.getAutoOffsetReset());
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configs);
    }

}
