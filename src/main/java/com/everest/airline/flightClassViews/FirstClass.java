package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;

public class FirstClass extends FlightClass {
    private String[] strings;
    private int passengers;
    public FirstClass(int passengers, String flightClass, Flight flight,String[] strings) {
        super(passengers, flightClass, flight);
        this.passengers=passengers;
        this.strings=strings;
        setFare(flight,passengers);
    }

    public void setFare(Flight flight, int passengers){
        flight.setTotalFare(flight.getSecondClassFare() * passengers);
    }
}
