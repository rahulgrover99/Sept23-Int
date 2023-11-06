package interfaces;

public class Main {
    public static void main(String[] args) {
        YesBank yesBank = new YesBank();
        ICICIBank iciciBank = new ICICIBank();

        PhonePe phonePe = new PhonePe(iciciBank);

        System.out.println(phonePe.checkBalance(122));
        System.out.println(phonePe.checkBalance(0));

        phonePe.pay("1", "2", 11);


    }
}
