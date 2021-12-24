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
    private double totalFare;
    private double baseFare;
    private int economicSeatsCapacity;
    private int firstClassSeatsCapacity;
    private int secondClassSeatsCapacity;

    public Flight(long number, String source, String destination,  LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, int availableSeats, int economicSeats, int secondClassSeats, int firstClassSeats, int economicSeatsCapacity, int secondClassSeatsCapacity , int firstClassSeatsCapacity,double baseFare) {
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
        this.baseFare = baseFare;
        this.economicSeatsCapacity=economicSeatsCapacity;
        this.firstClassSeatsCapacity=firstClassSeatsCapacity;
        this.secondClassSeatsCapacity=secondClassSeatsCapacity;
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

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getFirstClassFare() {
        return firstClassFare;
    }

    public double getSecondClassFare() {
        return secondClassFare;
    }


    public void setEconomicFare(double economicFare) {
        this.economicFare = economicFare;
    }

    public void setFirstClassFare(double firstClassFare) {
        this.firstClassFare = firstClassFare;
    }

    public void setSecondClassFare(double secondClassFare) {
        this.secondClassFare = secondClassFare;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public int getEconomicSeatsCapacity() {
        return economicSeatsCapacity;
    }

    public int getFirstClassSeatsCapacity() {
        return firstClassSeatsCapacity;
    }

    public int getSecondClassSeatsCapacity() {
        return secondClassSeatsCapacity;
    }

    public double getBaseFare() {
        return baseFare;
    }

}
