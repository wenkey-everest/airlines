package com.everest.airline;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    public Flight(long number, String source, String destination) {
        this.number = number;
        this.source = source;
        this.destination = destination;

    }

    public long getNumber() {
        return number;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }


}
