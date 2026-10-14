package com.piseth.springbeanscopedemo.request;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Getter
@Component
@RequestScope
public class RequestTrace {
    private final String traceId = UUID.randomUUID().toString();
}
