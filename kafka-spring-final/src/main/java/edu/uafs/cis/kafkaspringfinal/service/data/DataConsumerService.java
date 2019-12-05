package edu.uafs.cis.kafkaspringfinal.service.data;

import edu.uafs.cis.kafkaspringfinal.dataobject.data.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DataConsumerService {

    @Autowired
    private SimpMessagingTemplate template;
    
    @KafkaListener(topics = "${app.topic.data}")
    public void receive(@Payload Data data, @Headers MessageHeaders headers) {
  
        template.convertAndSend("/receive/websocket-data", data);
        
    }

}
