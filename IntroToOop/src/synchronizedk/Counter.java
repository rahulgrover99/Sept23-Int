package synchronizedk;

public class Counter {
    private int i = 0;

    public synchronized void increment() {
        i+=1;
    }

    public synchronized void decrement() {
        i-=1;
    }

    public int getI() {
        return i;
    }


}
