
package edu.uafs.cis.kafkaspringfinal.controller.data;
import edu.uafs.cis.kafkaspringfinal.dataobject.data.Data;
import edu.uafs.cis.kafkaspringfinal.dataobject.test.WebSocketTestSend;
import edu.uafs.cis.kafkaspringfinal.service.data.DataProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class DataWebSocketController {

  @Autowired 
  private DataProducerService producer;
  
  /* 
    This configuration sends data to a Kafka topic. 
    A separate service will listen for changes to the topic.
    
    It's not necessary to use Kafka to relay messages. 
    We can just use the annotation SendTo to relay data to a URL. 
    
    But, Kafka provides a pipeline that multiple services can read from.
    If multiple services need to use data sent through the socket,
    then it would be better to use Kafka to manage the data.
    
    @MessageMapping("/websocket-test")
    @SendTo("/receive/websocket-test")
    public WebSocketTestReceive testSocketResponse(WebSocketTestSend message) throws Exception {
      return new UAMessage(message.getValue(),HtmlUtils.htmlEscape(message.getMessage()));
    }
    
  */
  
  @MessageMapping("/websocket-data")
  public void messageSocketResponse(WebSocketTestSend message) throws Exception {
    this.producer.produceData(new Data(HtmlUtils.htmlEscape(message.getMessage()),message.getValue()));
    
  }

}
