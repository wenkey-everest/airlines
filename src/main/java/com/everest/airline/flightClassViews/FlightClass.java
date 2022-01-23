package com.everest.airline.flightClassViews;


public interface FlightClass {

  void setLine();

  void totalCost(int passengers);

  double classFareBySeats();

  boolean validateSeats(int passengers);



}
