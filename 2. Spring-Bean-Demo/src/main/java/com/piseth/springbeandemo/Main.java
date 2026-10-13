package com.piseth.springbeandemo;

import com.piseth.springbeandemo.config.AppConfig;
import com.piseth.springbeandemo.domain.ReceiptDraft;
import com.piseth.springbeandemo.service.TransferService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Clock;

public class Main {
    void main() {
        try (var context = new
                AnnotationConfigApplicationContext(AppConfig.class)) {
            var service1 = context.getBean(TransferService.class);
            var service2 = context.getBean(TransferService.class);
            IO.println("Same service: " + (service1 == service2));
            service1.simulateTransfer("CUST-001", 50);
            var draft1 = context.getBean(ReceiptDraft.class);
            var draft2 = context.getBean(ReceiptDraft.class);
            IO.println("Same draft: " + (draft1 == draft2));
            IO.println("Draft 1: " + draft1.getDraftId());
            IO.println("Draft 2: " + draft2.getDraftId());
            Clock clock = context.getBean("clock", Clock.class);
            IO.println("Clock zone: " + clock.getZone());
        }
    }
}

