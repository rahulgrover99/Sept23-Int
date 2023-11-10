package callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Power2 p2 = new Power2(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Power2 p2 = new Power2(i);
            futures.add(executorService.submit(p2));
        }

        System.out.println("Haha from the main thread.");

//        System.out.println(i.get());
        System.out.println(futures.get(0).get());

        System.out.println("Bye from the main thread");

        for (int i = 1; i < 10; i++) {
            System.out.println(futures.get(i).get());
        }

        executorService.shutdown();


    }

}
