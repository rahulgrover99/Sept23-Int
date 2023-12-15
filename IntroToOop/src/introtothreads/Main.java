package introtothreads;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter(100);

        // Providing this thread class with a Runnable type object.
        Thread t1 = new Thread(helloWorldPrinter);
        // A new thread created here, and main thread moved forward
        t1.start();

        // Anonymous class - a class with no name.
        // inline class
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world" + Thread.currentThread().getName());
                System.out.println(this.getClass().getName());
            }
        });

        t2.start();

        Runnable runnable = () -> System.out.println("5");
        Thread t3 = new Thread(runnable);


        Callable<Integer> callable = () -> {
            return 5;
        };

        // Replacing functional interfaces with lambdas
        // Syntax : (param a, param b) -> {
        // sout("lambda")
        // return a + b;

        // }

//        (a, b) -> a + b;
//        (a, b) -> {
//            return a + b;
//        }



        t3.start();

        // Main thread.
        // Gets printed without waiting for t1
        System.out.println("BBYE!");
    }
}
