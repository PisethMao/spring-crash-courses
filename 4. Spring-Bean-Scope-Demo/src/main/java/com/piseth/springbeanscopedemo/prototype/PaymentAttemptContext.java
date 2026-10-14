package com.piseth.springbeanscopedemo.prototype;

import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentAttemptContext {
    private final String attemptId = UUID.randomUUID().toString();
}
