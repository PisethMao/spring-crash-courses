package com.piseth.springdependencyinjectiondemo.notification;

import org.springframework.stereotype.Component;

@Component
public class ConsoleNotificationSender implements NotificationSender {
    @Override
    public void send(String customerId, String message) {
        System.out.printf("Notification for %s: %s%n", customerId, message);
    }
}
