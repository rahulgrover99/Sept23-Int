package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executorService.submit(np);
        }
        System.out.println(executorService);
        executorService.shutdown();
    }
}
