
package edu.uafs.cis.kafkaspringfinal.config.data;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class DataTopicConfig {
     
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
 
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    @Bean
    public NewTopic newTopic() {
         return new NewTopic("data", 1, (short) 1);
    }
    
}
