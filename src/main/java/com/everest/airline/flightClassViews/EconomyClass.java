package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;

public class EconomyClass implements FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;



    public EconomyClass(int passengers, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }

    @Override
    public String setLine() {
            line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() + "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," + flight.getArrivalDate() + "," + flight.getArrivalTime() + "," + (flight.getAvailableSeats() - passengers) + "," + (flight.getEconomicSeats() - passengers) + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats() + "," + flight.getEconomicSeatsCapacity()+","+flight.getFirstClassSeatsCapacity()+","+flight.getSecondClassSeatsCapacity()+","+flight.getBaseFare();
        return line;
    }
    @Override
    public double totalCost(int passengers) {
        totalCost = classFareBySeats()*passengers;
        flight.setTotalFare(totalCost);
        return totalCost;
    }
    @Override
    public double classFareBySeats(){
        Pricing pricing = new Pricing();
        double classFare= pricing.priceByDate(flight.getDepartureDate(),flight.getEconomicSeats(),flight.getEconomicSeatsCapacity(),flight.getBaseFare());
        flight.setEconomicFare(classFare);
        return classFare;
    }
    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getEconomicSeats();
    }


}


