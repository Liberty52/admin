package com.liberty52.admin.service.event.internal;

import com.liberty52.admin.service.event.Event;

public interface InternalEvent<T> extends Event {
    T getBody();
}
