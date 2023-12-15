package singleton;

public class MySingleObjectClass {

    private String x;
    private static MySingleObjectClass instance;

    private MySingleObjectClass() {

    }

    public static MySingleObjectClass createInstance() {
        // Here is where you will make a change?
        // T1, T2
        if (instance == null) {
            // T1 paused. Then T2 enters the if block.
            instance = new MySingleObjectClass();

        }
        return instance;
    }

}
