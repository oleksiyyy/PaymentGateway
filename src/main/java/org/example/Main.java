package org.example;

import Objects.Bank;
import Objects.PaymentProcessor;
import Objects.Terminal;
import Objects.Transaction;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Terminal terminal = new Terminal(bank);
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPurchase(terminal, 100);
        processor.processSale(terminal, 50);
        processor.processPurchase(terminal, 20);
        processor.processSale(terminal, 30);
        processor.processPurchase(terminal, 70);
        processor.processSale(terminal, 60);
        processor.processSale(terminal, 300);
        processor.processSale(terminal, 20);


        System.out.println("Transaction:");
        for (Transaction transaction : bank.getTransactions()) {
            System.out.println(transaction.getAmount());
        }
        System.out.println("Balance: " + bank.getBalance());
    }
}
