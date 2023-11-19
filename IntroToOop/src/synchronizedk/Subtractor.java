package synchronizedk;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    private Counter counter;

    public Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
//            System.out.println("Subtracting ith time: " + i);
//                System.out.println("Inside lock - Subtractor - "  + i);
                counter.decrement();
        }
    }
}
