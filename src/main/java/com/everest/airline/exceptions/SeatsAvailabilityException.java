package com.everest.airline.exceptions;

public class SeatsAvailabilityException extends RuntimeException{
    public SeatsAvailabilityException(Throwable e){
        super("Number of passengers is greater than available seats", e);
    }
}
