package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    Queue<Object> store;
    String name;

    Semaphore ps;
    Semaphore cs;

    public Producer(Queue<Object> store, String name, Semaphore ps, Semaphore cs) {
        this.store = store;
        this.name = name;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {


        try {
            ps.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("[%d] Producer %s produced a shirt in thread %s\n",
                store.size(), name, Thread.currentThread().getName());
        store.add(new Object());


        cs.release();

    }
}
