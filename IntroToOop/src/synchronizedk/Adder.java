package synchronizedk;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
//            System.out.println("Adding ith time: " + i);
            // If you want to move forward get the shared resource lock.
//                System.out.println("Inside lock - Adder - "  + i);
                counter.increment();
        }
    }
}
