package adapter;

public class PhonePe {

    private BankingService bankingService;

    public PhonePe(BankingService bankingService) {
        this.bankingService = bankingService;
    }


    void createBankAccount() {
        Bank bank = new Bank();
        bank.name = "Abhirup";
        bank.pan = "CKPPDDHODA";
        bank.aadhar = "232803299292";

        bankingService.addBankAccount(bank);

    }

    void listBankAccounts() {

    }

    void transferMoney() {

    }

}
