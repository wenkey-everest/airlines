package com.everest.airline.flightClassViews;


public abstract class FlightClass {

  public abstract String setLine();

  public abstract double totalCost(int passengers);

  public abstract boolean validateSeats(int passengers);



  public double priceBySeats(int availableSeats, int classCapacity, double basePrice){
    double classFare;
    if(availableSeats>classCapacity*0.7)
        return basePrice;
    else if(availableSeats<classCapacity*0.7 && availableSeats>classCapacity*0.5)
        return basePrice + (basePrice*0.2);
     else if(availableSeats<classCapacity*0.5 && availableSeats>classCapacity*0.25)
       return basePrice + (basePrice*0.35);
     else
       return basePrice + (basePrice*0.5);
  }

}
