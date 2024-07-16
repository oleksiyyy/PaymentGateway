package Objects;

public class PaymentProcessor {

    public void processPurchase(Terminal terminal, Integer amount) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(-amount);
        bank.addTransaction(transaction);
    }

    public void processSale(Terminal terminal, Integer amount) {
        Bank bank = terminal.getBank();
        Transaction transaction = new Transaction(amount);
        bank.addTransaction(transaction);
    }
}
