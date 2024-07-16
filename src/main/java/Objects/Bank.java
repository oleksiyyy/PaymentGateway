package Objects;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Transaction> transactions;
    private Integer balance;

    public Bank() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}
