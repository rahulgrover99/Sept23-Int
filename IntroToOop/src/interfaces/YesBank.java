package interfaces;

public class YesBank implements BankingService{
    @Override
    public double checkBalance(int accNo) {
        return -99;
    }

    @Override
    public void pay(int fromAcc, int toAcc, double amount) {
        System.out.println("SUCCESS from Yes bank.");
    }
}
