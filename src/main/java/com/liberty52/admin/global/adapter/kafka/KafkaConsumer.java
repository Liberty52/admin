package com.liberty52.admin.global.adapter.kafka;

public interface KafkaConsumer {

    void consumeMemberDeletedEvent(String authId);

}
