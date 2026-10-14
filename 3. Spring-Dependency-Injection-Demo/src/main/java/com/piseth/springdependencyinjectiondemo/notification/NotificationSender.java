package com.piseth.springdependencyinjectiondemo.notification;

public interface NotificationSender {
    void send(String customerId, String message);
}
