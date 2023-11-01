package otherpackage;

import intro.Batch;

public class Main {

    public static void main(String[] args) {
        Batch b = new Batch();
//        System.out.println(b.name);
        ChildClass c = new ChildClass();
        System.out.println(c.getName());
    }
}
