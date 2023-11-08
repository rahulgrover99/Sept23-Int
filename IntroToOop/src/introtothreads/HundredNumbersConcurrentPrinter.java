package introtothreads;

public class HundredNumbersConcurrentPrinter {

    public static void main(String[] args) {
        // main thread.
        for (int i = 0; i < 100; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i + 1);
            Thread t = new Thread(numberPrinter);
            System.out.println("Thread created for number " + i);
            // Independent
            t.start();
//            System.out.println("Number " + i + " printed from " +
//                    Thread.currentThread().getName());
        }
    }
}
