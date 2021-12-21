package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;

public class SecondClass extends FlightClass{
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    public SecondClass(int passengers, String flightClass, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }
    @Override
    public String setLine() {
        line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() + "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," + flight.getArrivalDate() + "," + flight.getArrivalTime() + "," + (flight.getAvailableSeats() - passengers) + "," + flight.getEconomicSeats()+ "," + (flight.getSecondClassSeats()-passengers) + "," + flight.getFirstClassSeats() + "," + flight.getEconomicSeatsCapacity()+","+flight.getFirstClassSeatsCapacity()+","+flight.getSecondClassSeatsCapacity()+","+flight.getBaseFare();
        return line;
    }

    @Override
    public double totalCost(int passengers) {
        totalCost = secondClassFareBySeats()*passengers;
        return totalCost;
    }

    public double secondClassFareBySeats(){
        double classFare=priceBySeats(flight.getSecondClassSeats(),flight.getSecondClassSeatsCapacity(),(flight.getBaseFare()*1.5));
        flight.setSecondClassFare(classFare);
        return classFare;
    }


    @Override
    public boolean validateSeats(int passengerCount) {
        return passengerCount < flight.getSecondClassSeats();
    }

}
