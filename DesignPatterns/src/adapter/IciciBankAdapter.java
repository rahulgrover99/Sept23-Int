package adapter;

import adapter.thirdparty.ICICIBankApi;

public class IciciBankAdapter implements BankingService{

    private final ICICIBankApi iciciBankApi;

    public IciciBankAdapter(ICICIBankApi iciciBankApi) {
        this.iciciBankApi = iciciBankApi;
    }

    @Override
    public void addBankAccount(Bank bank) {
        System.out.println("REGISTERING BANK ACCOUNT");
        iciciBankApi.addBankAccount(bank.name, bank.aadhar, bank.pan);
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
