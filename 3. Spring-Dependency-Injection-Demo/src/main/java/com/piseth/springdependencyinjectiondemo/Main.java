package com.piseth.springdependencyinjectiondemo;

import java.math.BigDecimal;

import com.piseth.springdependencyinjectiondemo.config.AppConfig;
import com.piseth.springdependencyinjectiondemo.service.TransferSimulationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    void main() {
        try (var context = new AnnotationConfigApplicationContext(
                AppConfig.class)) {
            TransferSimulationService service = context.getBean(
                    TransferSimulationService.class);
            service.simulateTransfer("CUSTOMER-001",
                    new BigDecimal("25.00"));
            service.simulateTransfer("CUSTOMER-001",
                    new BigDecimal("1500.00"));
        }
    }
}
