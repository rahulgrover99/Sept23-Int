package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Queue<Object> store;
    String name;

    Semaphore ps;
    Semaphore cs;

    public Consumer(Queue<Object> store, String name, Semaphore ps, Semaphore cs) {
        this.store = store;
        this.name = name;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {


        try {
            cs.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("[%d] Consumer %s consumed a shirt in thread %s\n",
                store.size(), name, Thread.currentThread().getName());
        store.remove();
        ps.release();

    }
}
