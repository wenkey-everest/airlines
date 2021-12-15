package com.everest.airline.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private double economicFare;
    private double firstClassFare;
    private double secondClassFare;
    public double totalFare;

    public Flight(long number, String source, String destination,  LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, int availableSeats, int economicSeats, int secondClassSeats, int firstClassSeats, double economicFare, double totalFare) {
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
        this.economicFare = economicFare;
        this.firstClassFare=getFirstClassSeats();
        this.secondClassFare=getSecondClassFare();
        this.totalFare=totalFare;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public long getNumber() {
        return number;
    }

    public String getSource() {
        return source;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
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

    public int getSecondClassSeats() {
        return secondClassSeats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }


    public double getEconomicFare() {
        return economicFare;
    }


    public double getFirstClassFare() {
        return getEconomicFare()*2;
    }

    public double getSecondClassFare() {
        return getEconomicFare()*1.5;
    }

}
