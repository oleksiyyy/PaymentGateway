package org.example.Objects;

import java.time.LocalDate;

public class Transaction {
    private final Integer amount;
    private final LocalDate date;
    private final String subscriberId;

    public Transaction(Integer amount, LocalDate date, String subscriberId) {
        this.amount = amount;
        this.date = date;
        this.subscriberId = subscriberId;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubscriberId() {
        return subscriberId;
    }
}
