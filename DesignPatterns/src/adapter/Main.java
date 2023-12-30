package adapter;

import adapter.thirdparty.ICICIBankApi;
import adapter.thirdparty.YesBankApi;

public class Main {

    public static void main(String[] args) {

        BankingService bankingService = SimpleAdaptorFactory.getAdapterInstance("ICICI");

        PhonePe phonePe = new PhonePe(bankingService);

        phonePe.createBankAccount();



    }
}
