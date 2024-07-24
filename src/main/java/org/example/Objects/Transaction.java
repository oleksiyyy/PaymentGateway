package org.example.Objects;

import java.time.LocalDate;

public class Transaction {
    private final Integer amount;
    private final LocalDate date;
    private final String clientId;

    public Transaction(Integer amount, LocalDate date, String clientId) {
        this.amount = amount;
        this.date = date;
        this.clientId = clientId;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getClientId() {
        return clientId;
    }
}
