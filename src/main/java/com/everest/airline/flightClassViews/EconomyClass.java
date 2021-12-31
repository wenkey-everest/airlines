package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;

public class EconomyClass implements FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int economicSeatsAvailable;
    private double economicClassFare;
    private int economicClassCapacity;

    public EconomyClass(int economicSeatsAvailable, int economicClassCapacity) {
        this.economicSeatsAvailable = economicSeatsAvailable;
        this.economicClassCapacity = economicClassCapacity;
    }

    public EconomyClass(int passengers, Flight  flight) {
        this.passengers = passengers;
        this.flight=flight;
    }

    @Override
    public String setLine() {
        int economicSeats = flight.getEconomyClass().getEconomicSeatsAvailable()- passengers;
        int secondClassSeats = flight.getSecondClass().getSecondClassSeatsAvailable();
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
        double classFare= pricing.priceByDate(flight.getDepartureDate(),flight.getEconomyClass().getEconomicSeatsAvailable(),flight.getEconomyClass().getEconomicClassCapacity(),flight.getBaseFare());
        flight.getEconomyClass().setEconomicClassFare(classFare);
        return classFare;
    }
    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getEconomyClass().getEconomicSeatsAvailable();
    }

    public void setEconomicClassFare(double economicClassFare) {
        this.economicClassFare = economicClassFare;
    }

    public int getEconomicSeatsAvailable() {
        return economicSeatsAvailable;
    }

    public double getEconomicClassFare() {
        return economicClassFare;
    }

    public int getEconomicClassCapacity() {
        return economicClassCapacity;
    }
}


