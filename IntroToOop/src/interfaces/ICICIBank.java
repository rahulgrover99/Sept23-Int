package interfaces;

public class ICICIBank implements BankingService, InvestmentService{
    @Override
    public double checkBalance(int accNo) {
        if (accNo == 0) {
            return -1;
        } else {
            return 100;
        }
    }

    @Override
    public void pay(int fromAcc, int toAcc, double amount) {
        System.out.println("SUCCESS to ICICI");
    }

    @Override
    public void invest() {

    }
}
