package com.mhk26.cqrs.core.producers;

import com.mhk26.cqrs.core.events.BaseEvent;

public interface EventProducer {
    void produce(String topic, BaseEvent event);
}
