package org.example;

import org.example.Objects.Bank;
import org.example.Objects.PaymentProcessor;
import org.example.Objects.Client;
import org.example.Objects.Terminal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("1", "Alice");
        Client client2 = new Client("2", "Bob");

        Bank bank = new Bank(Arrays.asList(client1, client2));

        Terminal terminal = new Terminal(bank);
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPurchase(terminal, 100, "1");
        processor.processSale(terminal, 50, "1");
        processor.processPurchase(terminal, 20, "2");
        processor.processSale(terminal, 30, "2");
        processor.processPurchase(terminal, 73, "1");
        processor.processSale(terminal, 60, "2");

        System.out.println("_______________________________________________________________________________________");

        bank.printTransactionsByClientId("1");

        System.out.println("_______________________________________________________________________________________");

        bank.printTransactionsByClientId("2");

        System.out.println("_______________________________________________________________________________________");

        bank.printTransactionsByDate(LocalDate.now());

        System.out.println("_______________________________________________________________________________________");

        System.out.println("Total Purchase Amount: " + bank.getTotalPurchaseAmount());

        System.out.println("_______________________________________________________________________________________");

        System.out.println("Total Sale Amount: " + bank.getTotalSaleAmount());
    }
}
