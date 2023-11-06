package interfaces;

public interface BankingService {

    // All methods of an interface are abstract and public.
    double checkBalance(int accNo);

    void pay(int fromAcc, int toAcc, double amount);
}
