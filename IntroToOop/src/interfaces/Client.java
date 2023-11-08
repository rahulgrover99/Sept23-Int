package interfaces;

public class Client {
    public static void main(String[] args) {
        C obj = new C();
        System.out.println(obj.d1);
        System.out.println(obj.d);
        obj.fun1();
        obj.fun();
        obj.sfun();
    }
}