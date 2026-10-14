package com.piseth.springbeanscopedemo.session;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@SessionScope
public class SessionVisits {
    @Getter
    private final String sessionBeanId = UUID.randomUUID().toString();
    private final AtomicInteger visits = new AtomicInteger();

    public void increment() {
        visits.incrementAndGet();
    }

    public int getVisits() {
        return visits.get();
    }
}
