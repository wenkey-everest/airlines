package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;

public class FirstClass extends FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    public FirstClass(int passengers, String flightClass, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }
    @Override
    public String setLine() {
        line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() + "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," + flight.getArrivalDate() + "," + flight.getArrivalTime() + "," + (flight.getAvailableSeats() - passengers) + "," + flight.getEconomicSeats() + "," + flight.getSecondClassSeats() + "," + (flight.getFirstClassSeats()-passengers) + "," + flight.getEconomicSeatsCapacity()+","+flight.getFirstClassSeatsCapacity()+","+flight.getSecondClassSeatsCapacity()+","+flight.getBaseFare();
        return line;
    }

    @Override
    public double totalCost(int passengers) {
        totalCost = firstClassFareBySeats()*passengers;
        return totalCost;
    }

    public double firstClassFareBySeats(){
        double classFare=priceByDate(flight.getDepartureDate(),flight.getFirstClassSeats(),flight.getFirstClassSeatsCapacity(),(flight.getBaseFare()*2));
        flight.setFirstClassFare(classFare);
        return classFare;
    }

    @Override
    public boolean validateSeats(int passengerCount) {
        return passengerCount < flight.getFirstClassSeats();
    }
}
