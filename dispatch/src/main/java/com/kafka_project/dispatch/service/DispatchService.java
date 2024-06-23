package com.kafka_project.dispatch.service;

import com.kafka_project.dispatch.message.OrderCreated;
import org.springframework.stereotype.Service;

@Service
public class DispatchService {

    public void process(OrderCreated payload) {
        // no-op
    }
}
