package edu.uafs.cis.kafkaspringfinal.controller.data;
import edu.uafs.cis.kafkaspringfinal.dataobject.data.Data;
import edu.uafs.cis.kafkaspringfinal.service.data.DataProducerService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class DataRESTController {
  
  @Value("${app.topic.data}") // Set in application.properties.
  private String topic;
  
  private DataProducerService producer;
  
  @Autowired 
  public DataRESTController(DataProducerService producer) {
    this.producer = producer;
  }
 
  @RequestMapping(value = "/send/rest-data", method = RequestMethod.GET) 
  public void postDataData( @RequestParam("value") int value , @RequestParam("content") String content ) {
    this.producer.produceData(new Data(content,value));
  }
  
}
