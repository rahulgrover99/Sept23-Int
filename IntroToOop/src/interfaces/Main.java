package interfaces;

public class Main {


    public static void main(String[] args) {

        // Non-static field 'x' cannot be referenced from a static context

        System.out.println(PhonePe.convertToDollars(23));
        System.out.println(PhonePe.counter);

        PhonePe.counter += 1;
//        PhonePe.COUNTER += 1;

        YesBank yesBank = new YesBank();
        ICICIBank iciciBank = new ICICIBank();

        PhonePe phonePe = new PhonePe(iciciBank);

        System.out.println(phonePe.checkBalance(122));
        System.out.println(phonePe.checkBalance(0));

        phonePe.pay("1", "2", 11);


    }
}
