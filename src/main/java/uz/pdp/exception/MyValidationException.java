package uz.pdp.exception;

public class MyValidationException extends RuntimeException {
    public MyValidationException(String msg) {
        super(msg);
    }
}
