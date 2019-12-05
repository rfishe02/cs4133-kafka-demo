package edu.uafs.cis;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.ExecutionException;
import java.util.Random;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;

public class App {
    
    public static void main( String[] args ) {
        
        JsonNode jNode;
        int value;
        
        try {
            
            /* Create a new Producer and Object Mapper. */
            
            Producer producer = ProducerConfiguration.getConfig();
            ObjectMapper objectMapper = new ObjectMapper(); 
            
            for(int i = 0; i < 3; i++) {
             
                value = (new Random()).nextInt(100) - 50;
                
                /* Convert a Data object to a json format. */

                jNode = objectMapper.valueToTree(new Data(value+"", 1));
                
                /* Create a ProducerRecord and write to a Kafka topic. */
                
                producer.send(new ProducerRecord<>("data",jNode));
         
            }
            
            /* Close the Producer. */ 
            
            producer.close();
            
        } catch ( Exception e) {
            //e.printStackTrace();
        }
        
    }
    
}
