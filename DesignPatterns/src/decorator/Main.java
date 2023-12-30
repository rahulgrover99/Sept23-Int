package decorator;

public class Main {

    public static void main(String[] args) {

        IceCream iceCream =
                new ChocolateSyrup(
                    new VanillaScoop(
                        new OrangeCone(
                                new VanillaScoop(
                                        new OrangeCone()))));

        System.out.println(iceCream.getDescription());
        System.out.println(iceCream.getCost());
    }
}
