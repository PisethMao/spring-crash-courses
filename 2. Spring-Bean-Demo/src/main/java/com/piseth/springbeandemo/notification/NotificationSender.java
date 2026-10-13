package com.piseth.springbeandemo.notification;

public interface NotificationSender {
    void send(String recipient, String message);
}
