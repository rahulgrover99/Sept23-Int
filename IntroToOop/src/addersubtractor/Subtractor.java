package addersubtractor;

public class Subtractor implements Runnable{
    private Counter counter;

    public Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.i -= 1;
        }
    }
}
