package singleton;

public class MulitthreadedSingleton1 {

    private String x;

    private static MulitthreadedSingleton1 mulitthreadedSingleton1;

    private MulitthreadedSingleton1() {
    }

    public static MulitthreadedSingleton1 getInstance() {
        if (mulitthreadedSingleton1 == null) {
            synchronized (MulitthreadedSingleton1.class) {
                if (mulitthreadedSingleton1 == null) {
                    // ?
                    mulitthreadedSingleton1 = new MulitthreadedSingleton1();
                }
            }
        }


        return mulitthreadedSingleton1;
    }
}
