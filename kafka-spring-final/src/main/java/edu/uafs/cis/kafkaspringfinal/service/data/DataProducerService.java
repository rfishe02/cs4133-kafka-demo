package edu.uafs.cis.kafkaspringfinal.service.data;
import edu.uafs.cis.kafkaspringfinal.dataobject.data.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class DataProducerService {
  
  @Value("${app.topic.data}")
  private String topic;
  
  @Autowired
  private KafkaTemplate<String, Data> template;

  public void produceData(Data data){

    Message<Data> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, topic).build();
    template.send(message);
    
  }

}
