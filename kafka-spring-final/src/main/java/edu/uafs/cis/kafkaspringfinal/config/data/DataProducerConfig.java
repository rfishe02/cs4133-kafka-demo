
package edu.uafs.cis.kafkaspringfinal.config.data;
import edu.uafs.cis.kafkaspringfinal.dataobject.data.Data;

import org.springframework.kafka.annotation.EnableKafka;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class DataProducerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;
    
  @Bean
  public Map<String, Object> dataProducerConfigs() {
    Map<String, Object> properties = new HashMap<>();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return properties;
  }

  @Bean
  public ProducerFactory<String, Data> kafkaProducerFactory() {
    return new DefaultKafkaProducerFactory<>(dataProducerConfigs());
  }

  @Bean
  public KafkaTemplate<String, Data> kafkaTemplate() {
    return new KafkaTemplate<>(kafkaProducerFactory());
  }

}
