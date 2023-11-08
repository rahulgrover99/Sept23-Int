package introtothreads;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter(100);


        Thread t1 = new Thread(helloWorldPrinter);
        // A new thread created here, and main thread moved forward
        t1.start();

        // Main thread.
        // Gets printed without waiting for t1
        System.out.println("BBYE!");
    }
}
