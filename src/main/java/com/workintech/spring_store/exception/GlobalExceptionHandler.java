package com.workintech.spring_store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//@ControllerAdvice (Intercepter) -> Bir problem anın da bu sınıf araya girer (Intercept eder.)
@ControllerAdvice
public class GlobalExceptionHandler {

    //Bu kısım da spesifik , kendi tanımladığım hataları yakalıyorum.
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StoreException storeException){
        ErrorResponse response = new ErrorResponse(storeException.getMessage(), Instant.now());
        return new ResponseEntity<>(response, storeException.getStatus());
    }

    //Bu kısım da benim yakalayamadığım / öngöremediğim genel hataları yakalıyorum
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse response = new ErrorResponse(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
