package com.liberty52.admin.service.event;

import com.liberty52.admin.global.adapter.kafka.KafkaProducer;
import com.liberty52.admin.service.event.kafka.KafkaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApplicationEventHandler {
    private final KafkaProducer kafkaProducer;

    @EventListener
    public void handleToKafkaEvent(KafkaEvent<?> event) {
        kafkaProducer.produceEvent(event);
    }

}
