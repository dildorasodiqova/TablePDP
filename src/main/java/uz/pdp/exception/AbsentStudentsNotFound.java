package uz.pdp.exception;

public class AbsentStudentsNotFound extends RuntimeException {
    public AbsentStudentsNotFound(String message) {
        super(message);
    }
}
