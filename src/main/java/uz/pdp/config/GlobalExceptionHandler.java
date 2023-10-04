package uz.pdp.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.exception.DataNotFoundException;

import java.util.zip.DataFormatException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DataFormatException.class)
    public ResponseEntity<String> dataNotFound (DataNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(value = DataAlreadyExistsException.class)
    public ResponseEntity<String> dataAlreadyExists(DataAlreadyExistsException e ) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }
}
