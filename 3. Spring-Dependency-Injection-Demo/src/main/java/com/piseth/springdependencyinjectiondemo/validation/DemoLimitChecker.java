package com.piseth.springdependencyinjectiondemo.validation;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class DemoLimitChecker {
    public boolean isAllowed(BigDecimal amount) {
        return amount != null && amount.signum() > 0 && amount.compareTo(
                new BigDecimal("1000.00")) <= 0;
    }
}
