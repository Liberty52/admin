package com.liberty52.admin.service.event.kafka;

import com.liberty52.admin.service.event.Event;

public interface KafkaEvent<T> extends Event {
    String getTopic();
    T getBody();
}
