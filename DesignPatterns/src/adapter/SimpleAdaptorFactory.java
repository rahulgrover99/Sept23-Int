package adapter;

import adapter.thirdparty.ICICIBankApi;

public class SimpleAdaptorFactory {

    public static BankingService getAdapterInstance(String type) {

        if (type == "ICICI") {
            new IciciBankAdapter(new ICICIBankApi());
        } else {
            new YesBankAdapter();
        }

        return null;
    }


}
