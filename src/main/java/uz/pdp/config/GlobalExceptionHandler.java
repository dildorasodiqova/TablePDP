package uz.pdp.config;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.pdp.exception.AuthException;
import uz.pdp.exception.DataAlreadyExistsException;
import uz.pdp.exception.DataNotFoundException;
import uz.pdp.exception.MyValidationException;

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
    @ExceptionHandler(value = AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<String> authenticateException(AuthenticationCredentialsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity<String> servletException (ExpiredJwtException e) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
    @ExceptionHandler(value = MyValidationException.class)
    public ResponseEntity<String> validException (MyValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(value = AuthException.class)
    public ResponseEntity<String> authException(AuthException e ) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
}
