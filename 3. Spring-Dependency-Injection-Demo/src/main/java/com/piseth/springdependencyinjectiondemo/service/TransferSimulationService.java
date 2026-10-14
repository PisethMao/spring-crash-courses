package com.piseth.springdependencyinjectiondemo.service;

import java.math.BigDecimal;

import com.piseth.springdependencyinjectiondemo.notification.NotificationSender;
import com.piseth.springdependencyinjectiondemo.validation.DemoLimitChecker;
import org.springframework.stereotype.Service;

@Service
public class TransferSimulationService {
    private final DemoLimitChecker limitChecker;
    private final NotificationSender notificationSender;

    public TransferSimulationService(
            DemoLimitChecker limitChecker,
            NotificationSender notificationSender
    ) {
        this.limitChecker = limitChecker;
        this.notificationSender = notificationSender;
    }

    public void simulateTransfer(
            String customerId,
            BigDecimal amount
    ) {
        if (!limitChecker.isAllowed(amount)) {
            IO.println("SIMULATED transfer rejected: "
                    + "amount outside demo limit");
            return;
        }
        System.out.printf("SIMULATED transfer accepted: %s USD%n", amount);
        notificationSender.send(customerId, "Demo transfer accepted");
    }
}
