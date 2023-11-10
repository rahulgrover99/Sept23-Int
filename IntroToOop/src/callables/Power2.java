package callables;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Power2 implements Callable<Integer> {

    int num;

    public Power2(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws InterruptedException {
        // task to be performed on a separate thread.
        TimeUnit.SECONDS.sleep(5);
        return (int) Math.pow(2, num);
    }
}
