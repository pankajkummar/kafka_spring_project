package com.kafka_project.dispatch.handler;

import com.kafka_project.dispatch.message.OrderCreated;
import com.kafka_project.dispatch.service.DispatchService;
import com.kafka_project.dispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderCreateHandlerTest {

    private OrderCreateHandler handler;
    private DispatchService dispatchServiceMock;

    @BeforeEach
    void setUp() {
        dispatchServiceMock = mock(DispatchService.class);
        handler = new OrderCreateHandler(dispatchServiceMock);
    }

    @Test
    void listen() {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(),randomUUID().toString());
        handler.listen(testEvent);
        verify(dispatchServiceMock,times(1)).process(testEvent);
    }
}