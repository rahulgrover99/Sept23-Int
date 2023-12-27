package adapter;

import adapter.thirdparty.YesBankApi;


// Adapter.
public class YesBankAdapter implements BankingService{

    private final YesBankApi yesBankApi = new YesBankApi();

//    public YesBankAdapter(YesBankApi yesBankApi) {
//        this.yesBankApi = yesBankApi;
//    }


    @Override
    public void addBankAccount(Bank bank) {
        System.out.printf("Calling yes bank api for registering bank account %s", bank.name);
        yesBankApi.registerBankAccount(bank.type, bank.name, bank.pan, bank.dob, bank.fname);
    }

    @Override
    public boolean pay(double amount, String account) {
        return false;
    }

    @Override
    public double checkBalance() {
        return 0;
    }
}
