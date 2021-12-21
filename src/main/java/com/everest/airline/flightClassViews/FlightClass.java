package com.everest.airline.flightClassViews;


public interface FlightClass {

    String setLine();

    double totalCost(int passengers);

    boolean validateSeats(int passengers);



}
