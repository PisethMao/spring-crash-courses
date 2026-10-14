package com.piseth.springbeanscopedemo.singleton;

import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Getter
@Service
public class PaymentPolicyService {
    private final String instanceId = UUID.randomUUID().toString();

    public String getPolicy() {
        return "Payments must pass validation";
    }
}
