package com.everest.airline.flightClassViews;


public interface FlightClass {

  String setLine();

  void totalCost(int passengers);

  double classFareBySeats();

  boolean validateSeats(int passengers);



}
