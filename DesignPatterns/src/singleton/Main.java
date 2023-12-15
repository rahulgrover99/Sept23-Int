package singleton;

public class Main {

    public static void main(String[] args) {

        MySingleObjectClass o1 = MySingleObjectClass.createInstance();
        MySingleObjectClass o2 = MySingleObjectClass.createInstance();
        System.out.println("DEBUG");

    }
}
