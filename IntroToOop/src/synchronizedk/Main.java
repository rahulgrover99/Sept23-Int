package synchronizedk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        System.out.println("Threads started....");

        // Blocking the main thread and making it wait for the other
        // threads to complete
        t1.join();
        t2.join();

        System.out.println("Value of the i in counter: " + counter.getI());

    }
}
