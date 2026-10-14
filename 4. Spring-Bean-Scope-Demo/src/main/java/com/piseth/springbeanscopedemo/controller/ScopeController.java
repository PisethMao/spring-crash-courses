package com.piseth.springbeanscopedemo.controller;

import com.piseth.springbeanscopedemo.application.GlobalStatistics;
import com.piseth.springbeanscopedemo.prototype.PaymentAttemptContext;
import com.piseth.springbeanscopedemo.request.RequestTrace;
import com.piseth.springbeanscopedemo.session.SessionVisits;
import com.piseth.springbeanscopedemo.singleton.PaymentPolicyService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/scopes")
public class ScopeController {
    private final PaymentPolicyService policy;
    private final ObjectProvider<PaymentAttemptContext> attempts;
    private final RequestTrace requestTrace;
    private final SessionVisits sessionVisits;
    private final GlobalStatistics statistics;

    public ScopeController(
            PaymentPolicyService policy,
            ObjectProvider<PaymentAttemptContext> attempts,
            RequestTrace requestTrace,
            SessionVisits sessionVisits,
            GlobalStatistics statistics
    ) {
        this.policy = policy;
        this.attempts = attempts;
        this.requestTrace = requestTrace;
        this.sessionVisits = sessionVisits;
        this.statistics = statistics;
    }

    @GetMapping("/singleton")
    public Map<String, Object> singleton() {
        return Map.of("scope", "singleton",
                "instanceId", policy.getInstanceId(),
                "policy", policy.getPolicy()
        );
    }

    @GetMapping("/prototype")
    public Map<String, Object> prototype() {
        PaymentAttemptContext first = attempts.getObject();
        PaymentAttemptContext second = attempts.getObject();
        return Map.of("scope", "prototype",
                "firstId", first.getAttemptId(),
                "secondId", second.getAttemptId(),
                "sameInstance", first == second
        );
    }

    @GetMapping("/request")
    public Map<String, Object> request() {
        return Map.of("scope", "request",
                "firstTraceId", requestTrace.getTraceId(),
                "secondTraceId", requestTrace.getTraceId()
        );
    }

    @GetMapping("/session")
    public Map<String, Object> session() {
        return sessionResponse();
    }

    @PostMapping("/session/increment")
    public Map<String, Object> incrementSession() {
        sessionVisits.increment();
        return sessionResponse();
    }

    private Map<String, Object> sessionResponse() {
        return Map.of("scope", "session",
                "sessionBeanId", sessionVisits.getSessionBeanId(),
                "visits", sessionVisits.getVisits()
        );
    }

    @GetMapping("/application")
    public Map<String, Object> application() {
        return applicationResponse();
    }

    @PostMapping("/application/increment")
    public Map<String, Object> incrementApplication() {
        statistics.increment();
        return applicationResponse();
    }

    private Map<String, Object> applicationResponse() {
        return Map.of("scope", "application",
                "instanceId", statistics.getInstanceId(),
                "operations", statistics.getOperations()
        );
    }
}
