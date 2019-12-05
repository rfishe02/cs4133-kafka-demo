
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

  // Place your code here.

}
