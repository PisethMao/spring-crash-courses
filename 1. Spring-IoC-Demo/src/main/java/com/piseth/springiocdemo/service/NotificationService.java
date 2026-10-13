package com.piseth.springiocdemo.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
        IO.println("NotificationService created");
    }

    public void notifyCustomer(String customerId, String message) {
        messageSender.send(customerId, message);
    }
}

