package adapter;


// Target Interface
public interface BankingService {
    void addBankAccount(Bank bank);
    boolean pay(double amount, String account);
    double checkBalance();
}
