package com.everest.airline.exceptions;

public class ThrowableException extends RuntimeException{
    public ThrowableException(String error, Throwable e) {
        super(error, e);
    }
}
