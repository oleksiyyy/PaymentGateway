package org.example.Objects;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    private final Map<String, Client> clients;

    public Bank(List<Client> clients) {
        this.clients = clients.stream()
                .collect(Collectors.toMap(Client::getId, client -> client));
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
    }

    public Client getClientById(String id) {
        return clients.get(id);
    }

    public List<Transaction> getTransactionsByClientId(String id) {
        Client client = getClientById(id);
        if (client != null) {
            return client.getTransactions();
        }
        return List.of();
    }

    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return clients.values().stream()
                .flatMap(client -> client.getTransactions().stream())
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public int getTotalPurchaseAmount() {
        return clients.values().stream()
                .flatMap(client -> client.getTransactions().stream())
                .filter(transaction -> transaction.getAmount() < 0)
                .mapToInt(Transaction::getAmount)
                .sum();
    }

    public int getTotalSaleAmount() {
        return clients.values().stream()
                .flatMap(client -> client.getTransactions().stream())
                .filter(transaction -> transaction.getAmount() > 0)
                .mapToInt(Transaction::getAmount)
                .sum();
    }

    public void printTransactionsByClientId(String clientId) {
        Client client = getClientById(clientId);
        if (client != null) {
            System.out.println("Id: " + client.getId());
            System.out.println("Name: " + client.getName());
            System.out.println("Balance: " + client.getBalance());
            System.out.println("Transactions:");
            client.getTransactions().forEach(transaction ->
                    System.out.println("Date: " + transaction.getDate() + ", Amount: " + transaction.getAmount()));
        } else {
            System.out.println("Client With Id " + clientId + " Not Found.");
        }
    }

    public void printTransactionsByDate(LocalDate date) {
        List<Transaction> transactions = getTransactionsByDate(date);
        if (!transactions.isEmpty()) {
            System.out.println("Transactions On Date: " + date);
            transactions.forEach(transaction ->
                    System.out.println("Client Id: " + transaction.getClientId() + ", Amount: " + transaction.getAmount()));
        } else {
            System.out.println("No Transactions Found On Date: " + date);
        }
    }
}
