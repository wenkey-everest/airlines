package com.everest.airline.exceptions;

import java.time.LocalDate;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(LocalDate depatureDate){
        super("Flight not found for date: "+depatureDate);
    }
}
