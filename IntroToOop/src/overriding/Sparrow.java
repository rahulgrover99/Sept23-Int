package overriding;

public class Sparrow extends Bird{

    @Override
    void fly() {
        System.out.println("I can fly high!!!!");
    }

    void eat() {
        System.out.println("I am eating");
    }

}
