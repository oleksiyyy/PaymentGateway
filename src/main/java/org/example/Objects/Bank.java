package org.example.Objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    private final Map<String, Subscriber> subscribers;

    public Bank(List<Subscriber> subscribers) {
        this.subscribers = subscribers.stream()
                .collect(Collectors.toMap(Subscriber::getId, subscriber -> subscriber));
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
    }

    public Subscriber getSubscriberById(String id) {
        return subscribers.get(id);
    }

    public List<Transaction> getTransactionsBySubscriberId(String id) {
        Subscriber subscriber = getSubscriberById(id);
        if (subscriber != null) {
            return subscriber.getTransactions();
        }
        return new ArrayList<>();
    }

    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return subscribers.values().stream()
                .flatMap(subscriber -> subscriber.getTransactions().stream())
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public int getTotalPurchaseAmount() {
        return subscribers.values().stream()
                .flatMap(subscriber -> subscriber.getTransactions().stream())
                .filter(transaction -> transaction.getAmount() < 0)
                .mapToInt(Transaction::getAmount)
                .sum();
    }

    public int getTotalSaleAmount() {
        return subscribers.values().stream()
                .flatMap(subscriber -> subscriber.getTransactions().stream())
                .filter(transaction -> transaction.getAmount() > 0)
                .mapToInt(Transaction::getAmount)
                .sum();
    }
}
