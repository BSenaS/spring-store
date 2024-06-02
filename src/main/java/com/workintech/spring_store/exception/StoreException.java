package com.workintech.spring_store.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StoreException extends RuntimeException{
    private HttpStatus status;

    public StoreException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
