package overriding;

public class Zoo {
    public static void main(String[] args) {
        Bird b1 = new Sparrow();

        Sparrow s1 = (Sparrow) b1;

        System.out.println("DEBUG");


//        sparrow.eat();
        b1.eat();
//        Bird s1 = new Sparrow();
//        Bird s2 = new Sparrow();
//        Bird p1 = new Penguin();
//        p1.fly();
//        makeBirdsFly(s1, s2, p1);
    }

    static void makeBirdsFly(Bird... birds) {
        for (Bird bird: birds) {
            bird.fly();
        }
    }
}
