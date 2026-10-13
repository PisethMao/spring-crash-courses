package com.piseth.springbeandemo.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender {
    public EmailNotificationSender() {
        IO.println("[constructor] EmailNotificationSender");
    }

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[mock email] To=%s, Message=%s%n",
                recipient, message
        );
    }
}
