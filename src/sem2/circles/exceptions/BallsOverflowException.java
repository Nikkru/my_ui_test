package sem2.circles.exceptions;

public class BallsOverflowException extends RuntimeException {
    public BallsOverflowException() {
        super("Impossible create over 15 balls");
    }
}
