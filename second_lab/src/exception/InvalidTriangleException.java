package exception;

public class InvalidTriangleException extends Exception {
    public InvalidTriangleException() {
        super();
    }
    public InvalidTriangleException(String message) {
        super(message);
    }
    public InvalidTriangleException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidTriangleException(Throwable cause) {
        super(cause);
    }
}
