package exceptions;

public class InvalidCellException extends Exception{
    public InvalidCellException(String message) {
        super(message);
    }

    public InvalidCellException() {
        super("Cell chosen by the user was already occupied or was out of bounds.");
    }
}
