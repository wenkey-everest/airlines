package com.everest.airline.model;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.SecondClass;

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
    private double totalFare;
    private double baseFare;
    private EconomyClass economyClass;
    private SecondClass secondClass;
    private FirstClass firstClass;

    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, int availableSeats, EconomyClass economyClass,SecondClass secondClass, FirstClass firstClass, double baseFare) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime=departureTime;
        this.arrivalDate=arrivalDate;
        this.arrivalTime=arrivalTime;
        this.availableSeats=availableSeats;
        this.economyClass=economyClass;
        this.secondClass=secondClass;
        this.firstClass=firstClass;
        this.baseFare = baseFare;
    }

    public String flightString(int noOfPass, int economicClassSeats, int firstClassSeats, int secondClassSeats){
        return getNumber()+","+getSource()+","+getDestination()+","+getDepartureDate()+","+getDepartureTime()+","+getArrivalDate()+","+getArrivalTime()+","+(getAvailableSeats()-noOfPass)+","+ economicClassSeats+","+ secondClassSeats+","+ firstClassSeats+","+ economyClass.getEconomicClassCapacity()+","+ secondClass.getSecondClassCapacity()+","+ firstClass.getFirstClassCapacity()+","+getBaseFare();
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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }


    public int getAvailableSeats() {
        return availableSeats;
    }


    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public EconomyClass getEconomyClass() {
        return economyClass;
    }

    public SecondClass getSecondClass() {
        return secondClass;
    }

    public FirstClass getFirstClass() {
        return firstClass;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
}
