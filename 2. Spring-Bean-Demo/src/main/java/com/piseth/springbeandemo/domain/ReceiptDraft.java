package com.piseth.springbeandemo.domain;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Component
@Scope("prototype")
public class ReceiptDraft {
    private final String draftId = UUID.randomUUID().toString();

    public ReceiptDraft() {
        IO.println("[constructor] ReceiptDraft (prototype)");
    }
}
