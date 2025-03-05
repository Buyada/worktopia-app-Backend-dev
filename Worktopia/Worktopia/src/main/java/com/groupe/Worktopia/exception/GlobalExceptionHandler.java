package com.groupe.Worktopia.exception;

import com.groupe.Worktopia.exception.RessourceExistException;
import com.groupe.Worktopia.exception.RessourceNotFoundException;
import com.groupe.Worktopia.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(RessourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(
                        HttpStatus.NOT_FOUND.value(),
                        LocalDateTime.now(),
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.getReasonPhrase()
                ));
    }

    @ExceptionHandler(RessourceExistException.class)
    public ResponseEntity<ErrorMessage> handleResourceExistException(RessourceExistException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now(),
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()
                ));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        LocalDateTime.now(),
                        "Une erreur interne s'est produite",
                        ex.getMessage()
                ));
    }
}