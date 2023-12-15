package singleton;

// Eager initialization
public class MultithreadedSingleton2 {

    private String x;

    private static MultithreadedSingleton2 instance = new MultithreadedSingleton2();

    private MultithreadedSingleton2() {}

    public static MultithreadedSingleton2 getInstance() {
        return instance;
    }
}
