package com.everest.airline.flightClassViews;


public abstract class FlightClass {

  public abstract String setLine();

  public abstract double totalCost(int passengers);

  public abstract boolean validateSeats(int passengers);



}
