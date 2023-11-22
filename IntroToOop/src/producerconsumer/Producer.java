package producerconsumer;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
