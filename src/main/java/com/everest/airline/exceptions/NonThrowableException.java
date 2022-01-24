package com.everest.airline.exceptions;

public class NonThrowableException extends RuntimeException{
    public NonThrowableException(String err) {
        super(err);
    }
}
