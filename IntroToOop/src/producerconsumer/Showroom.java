package producerconsumer;

import diamond.C;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Showroom {
    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();

        Semaphore ps = new Semaphore(5);
        Semaphore cs = new Semaphore(0);

        for (int i  = 0; i < 1000; i++) {
            Producer p = new Producer(queue, "P" + i, ps, cs);
            Consumer c = new Consumer(queue, "C" + i, ps, cs);

            Thread tp = new Thread(p);
            Thread tc = new Thread(c);

            tp.start();
            tc.start();
        }
    }
}
