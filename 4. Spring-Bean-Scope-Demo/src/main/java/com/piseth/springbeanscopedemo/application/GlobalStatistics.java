package com.piseth.springbeanscopedemo.application;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Component
@ApplicationScope
public class GlobalStatistics {
    @Getter
    private final String instanceId = UUID.randomUUID().toString();
    private final AtomicLong operations = new AtomicLong();

    public void increment() {
        operations.incrementAndGet();
    }

    public long getOperations() {
        return operations.get();
    }
}
