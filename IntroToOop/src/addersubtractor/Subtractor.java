package addersubtractor;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    private Counter counter;
    private Lock lock;

    public Subtractor(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Subtracting ith time: " + i);
            lock.lock();
            System.out.println("Inside lock - Subtractor - "  + i);
            counter.i -= 1;
            lock.unlock();
        }
    }
}
