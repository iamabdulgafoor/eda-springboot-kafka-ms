package app.abdul.orderservice.controller;

import app.abdul.basedomains.dto.OrderDto;
import app.abdul.basedomains.dto.OrderEvent;
import app.abdul.orderservice.kafkaproducer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderEventController {

    @Autowired
    private OrderProducer OrderProducer;
    @PostMapping("/orders")
    public ResponseEntity<String> acceptEventOrder(@RequestBody OrderDto order ){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();

        orderEvent.setOrderStatus("PENDING");
        orderEvent.setOrderMessage("Order status in pending state");
        orderEvent.setOrder(order);

        OrderProducer.sendMessage(orderEvent);

        return new ResponseEntity<>("Order Placed Successfully..!!!s", HttpStatus.ACCEPTED);
    }

}
