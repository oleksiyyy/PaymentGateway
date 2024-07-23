package org.example;

import org.example.Objects.Bank;
import org.example.Objects.PaymentProcessor;
import org.example.Objects.Subscriber;
import org.example.Objects.Terminal;
import org.example.Objects.Transaction;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Subscriber subscriber1 = new Subscriber("1", "Alice");
        Subscriber subscriber2 = new Subscriber("2", "Bob");

        Bank bank = new Bank(Arrays.asList(subscriber1, subscriber2));

        Terminal terminal = new Terminal(bank);
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPurchase(terminal, 100, "1");
        processor.processSale(terminal, 50, "1");
        processor.processPurchase(terminal, 20, "2");
        processor.processSale(terminal, 30, "2");
        processor.processPurchase(terminal, 73, "1");
        processor.processSale(terminal, 60, "2");

        System.out.println("Transactions for subscriber 1:");
        bank.getTransactionsBySubscriberId("1").forEach(transaction -> System.out.println(transaction.getAmount()));

        System.out.println("Transactions on current date:");
        bank.getTransactionsByDate(LocalDate.now()).forEach(transaction -> System.out.println(transaction.getAmount()));

        System.out.println("Total purchase amount: " + bank.getTotalPurchaseAmount());
        System.out.println("Total sale amount: " + bank.getTotalSaleAmount());
    }
}
