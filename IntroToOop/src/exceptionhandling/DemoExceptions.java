package exceptionhandling;

public class DemoExceptions extends Exception{

    DemoExceptions() {
        super("DEMO EXCEPTION");
    }

    public DemoExceptions(String message) {
        super(message);
    }
}
