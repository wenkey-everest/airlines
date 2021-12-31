package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;

public class SecondClass implements FlightClass{
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int secondClassSeatsAvailable;
    private double secondClassFare;
    private int secondClassCapacity;

    public SecondClass(int secondClassSeatsAvailable, int secondClassCapacity) {
        this.secondClassSeatsAvailable = secondClassSeatsAvailable;
        this.secondClassCapacity = secondClassCapacity;
    }

    public SecondClass(int passengers, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }

    @Override
    public String setLine() {
        int economicSeats = flight.getEconomyClass().getEconomicSeatsAvailable();
        int secondClassSeats = flight.getSecondClass().getSecondClassSeatsAvailable() - passengers;
        int firstClassSeats = flight.getFirstClass().getFirstClassSeatsAvailable();
        line = flight.flightString(passengers,economicSeats,secondClassSeats,firstClassSeats);
        return line;
    }

    @Override
    public void totalCost(int passengers) {
        totalCost = classFareBySeats()*passengers;
        flight.setTotalFare(totalCost);
    }

    @Override
    public double classFareBySeats(){
        Pricing pricing = new Pricing();
        double classFare= pricing.priceByDate(flight.getDepartureDate(),flight.getSecondClass().getSecondClassSeatsAvailable(),flight.getSecondClass().getSecondClassCapacity(),(flight.getBaseFare()*1.5));
        flight.getSecondClass().setSecondClassFare(classFare);
        return classFare;
    }

    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getSecondClass().getSecondClassSeatsAvailable();
    }

    public void setSecondClassFare(double secondClassFare) {
        this.secondClassFare = secondClassFare;
    }

    public int getSecondClassSeatsAvailable() {
        return secondClassSeatsAvailable;
    }

    public double getSecondClassFare() {
        return secondClassFare;
    }

    public int getSecondClassCapacity() {
        return secondClassCapacity;
    }
}
