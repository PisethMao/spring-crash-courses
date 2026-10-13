package com.piseth.springbeandemo.service;

import com.piseth.springbeandemo.notification.NotificationSender;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

@Service
public class TransferService {
    private final NotificationSender notificationSender;
    private final Clock clock;

    public TransferService(
            NotificationSender notificationSender,
            Clock clock
    ) {
        this.notificationSender = notificationSender;
        this.clock = clock;
        IO.println("[constructor] TransferService");
    }

    @PostConstruct
    public void init() {
        IO.println("[post-construct] TransferService ready");
    }

    public void simulateTransfer(String customerId, int amountUsd) {
        Instant timestamp = clock.instant();
        String message = "Simulation only: $"
                + amountUsd + " at " + timestamp;
        notificationSender.send(customerId, message);
    }

    @PreDestroy
    public void shutdown() {
        IO.println("[pre-destroy] TransferService cleanup");
    }
}
