package com.kafka_project.dispatch.handler;

import com.kafka_project.dispatch.message.OrderCreated;
import com.kafka_project.dispatch.service.DispatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCreateHandler {

    private final DispatchService dispatchService;

    @KafkaListener(
            id = "orderConsumerClient",
            topics = "order.created",
            groupId = "dispatch.order.created.consumer"
    )

    public void listen(OrderCreated payload){
        log.info("Received message: payload: " + payload);
        dispatchService.process(payload);

    }
}
