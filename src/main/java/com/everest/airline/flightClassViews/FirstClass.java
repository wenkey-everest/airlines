package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;

public class FirstClass implements FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int firstClassSeatsAvailable;
    private double firstClassFare;
    private int firstClassCapacity;

    public FirstClass(int firstClassSeatsAvailable, int firstClassCapacity) {
        this.firstClassSeatsAvailable = firstClassSeatsAvailable;
        this.firstClassCapacity = firstClassCapacity;
    }

    public FirstClass(int passengers, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }
    @Override
    public String setLine() {
        int economicSeats = flight.getEconomyClass().getEconomicSeatsAvailable();
        int secondClassSeats = flight.getSecondClass().getSecondClassSeatsAvailable();
        int firstClassSeats = flight.getFirstClass().getFirstClassSeatsAvailable() - passengers;
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
        double classFare=pricing.priceByDate(flight.getDepartureDate(),flight.getFirstClass().getFirstClassSeatsAvailable(),flight.getFirstClass().getFirstClassCapacity(),(flight.getBaseFare()*2));
        flight.getFirstClass().setFirstClassFare(classFare);
        return classFare;
    }

    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getFirstClass().getFirstClassSeatsAvailable();
    }


    public void setFirstClassFare(double firstClassFare) {
        this.firstClassFare = firstClassFare;
    }

    public int getFirstClassSeatsAvailable() {
        return firstClassSeatsAvailable;
    }

    public double getFirstClassFare() {
        return firstClassFare;
    }

    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }
}
