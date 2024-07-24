package org.example.Objects;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String id;
    private final String name;
    private final List<Transaction> transactions;
    private Integer balance;

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
    }
}
