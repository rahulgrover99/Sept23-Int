package interfaces;

public interface BankingService {

    // static and final -> THEY ARE CONSTANTS AND CAN'T BE CHANGED/.
    int count = 0;
    // All methods of an interface are abstract and public.
    double checkBalance(int accNo);

    void pay(int fromAcc, int toAcc, double amount);
}
