package com.everest.airline.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private int availableSeats;
    private int economicSeats;
    private int firstClassSeats;
    private int secondClassSeats;

    public Flight(long number, String source, String destination,  LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, int availableSeats, int economicSeats, int firstClassSeats, int secondClassSeats) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate= departureDate;
        this.departureTime=departureTime;
        this.arrivalDate=arrivalDate;
        this.arrivalTime=arrivalTime;
        this.availableSeats=availableSeats;
        this.economicSeats=economicSeats;
        this.firstClassSeats=firstClassSeats;
        this.secondClassSeats=secondClassSeats;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getEconomicSeats() {
        return economicSeats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public int getSecondClassSeats() {
        return secondClassSeats;
    }
}
