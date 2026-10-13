package com.piseth.springiocdemo.service;

import org.springframework.stereotype.Component;

@Component
public class ConsoleMessageSender implements MessageSender {
    public ConsoleMessageSender() {
        IO.println("ConsoleMessageSender created");
    }

    @Override
    public void send(String customerId, String message) {
        IO.println("Sending notification to: " + customerId);
        IO.println("Message: " + message);
    }
}

