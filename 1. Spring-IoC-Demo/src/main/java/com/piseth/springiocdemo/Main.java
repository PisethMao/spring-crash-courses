package com.piseth.springiocdemo;

import com.piseth.springiocdemo.config.AppConfig;
import com.piseth.springiocdemo.service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    void main() {
        try (var context = new AnnotationConfigApplicationContext(
                AppConfig.class
        )) {
            NotificationService service =
                    context.getBean(NotificationService.class);
            service.notifyCustomer(
                    "CUS001",
                    "Your transaction was completed successfully."
            );
            NotificationService anotherService =
                    context.getBean(NotificationService.class);
            IO.println("Same instance: " + (service == anotherService));
        }
    }
}

