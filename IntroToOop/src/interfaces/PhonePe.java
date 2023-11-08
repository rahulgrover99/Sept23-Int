package interfaces;

public class PhonePe {

    // Variable 'COUNTER' might not have been initialized
    static final int COUNTER = 1;
    static int counter = 1;
    static double convertToDollars(int ruppees) {
        return ruppees/87.0;
    }

    private final BankingService bankingService;
    public PhonePe(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    void addUpi(String upi){
        System.out.println("Added UPI.");
    }

    double checkBalance(String upi) {
        return 90;
    }

    double checkBalance(int acc) {
        return bankingService.checkBalance(acc);
    }

    void pay(String from, String to, double amount) {
        // Get acc for "from" UPI
        bankingService.pay(12,23, amount);
    }
}
