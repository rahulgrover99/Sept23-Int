package adapter;

import adapter.thirdparty.ICICIBankApi;
import adapter.thirdparty.YesBankApi;

public class Main {

    public static void main(String[] args) {
        YesBankAdapter yesBankAdapter = new YesBankAdapter();
        IciciBankAdapter iciciBankAdapter = new IciciBankAdapter(new ICICIBankApi());



        PhonePe phonePe = new PhonePe(iciciBankAdapter);

        phonePe.createBankAccount();



    }
}
