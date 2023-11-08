package introtothreads;

public class HelloWorldPrinter implements Runnable{

    int i;

    public HelloWorldPrinter(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Number passed: " + i + " from: " + Thread.currentThread().getName());
        System.out.println("Hello world from " + Thread.currentThread().getName());
    }
}
