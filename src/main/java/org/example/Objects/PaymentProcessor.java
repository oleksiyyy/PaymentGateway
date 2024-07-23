package org.example.Objects;

import java.time.LocalDate;

public class PaymentProcessor {

    public void processPurchase(Terminal terminal, Integer amount, String subscriberId) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(-amount, LocalDate.now(), subscriberId);
        Subscriber subscriber = bank.getSubscriberById(subscriberId);
        if (subscriber != null) {
            subscriber.addTransaction(transaction);
        }
    }

    public void processSale(Terminal terminal, Integer amount, String subscriberId) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(amount, LocalDate.now(), subscriberId);
        Subscriber subscriber = bank.getSubscriberById(subscriberId);
        if (subscriber != null) {
            subscriber.addTransaction(transaction);
        }
    }
}
