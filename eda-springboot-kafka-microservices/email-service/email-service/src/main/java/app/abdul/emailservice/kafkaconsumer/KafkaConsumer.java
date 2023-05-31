package app.abdul.emailservice.kafkaconsumer;

import app.abdul.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){

        LOGGER.info(String.format("Email Event Message Recieved is ==> %s",orderEvent.toString()));

        // NEXT STEP:==>  Send the order details to the customer through the email

    }
}