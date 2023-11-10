package callables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Power2 p2 = new Power2(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> i = executorService.submit(p2);

        System.out.println("Haha from the main thread.");

        System.out.println(i.get());

        System.out.println("Bye from the main thread");

        executorService.shutdown();


    }

}
