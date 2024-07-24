package org.example.Objects;

import java.time.LocalDate;

public class PaymentProcessor {

    public void processPurchase(Terminal terminal, Integer amount, String clientId) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(-amount, LocalDate.now(), clientId);
        Client client = bank.getClientById(clientId);
        if (client != null) {
            client.addTransaction(transaction);
        }
    }

    public void processSale(Terminal terminal, Integer amount, String clientId) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(amount, LocalDate.now(), clientId);
        Client client = bank.getClientById(clientId);
        if (client != null) {
            client.addTransaction(transaction);
        }
    }
}
