package com.everest.airline.flightClass;

import com.everest.airline.model.Flight;

public class SecondClass extends FlightClass{
    private String line;
    private String[] strings;
    private int passengers;
    public SecondClass(int passengers, String flightClass, Flight flight, String[] strings) {
        super(passengers, flightClass, flight);
        this.passengers=passengers;
        this.strings=strings;
        setLine();
        setFare(flight,passengers);
    }
    public void setLine(){
        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + strings[8] + "," + strings[9] + "," + (Integer.parseInt(strings[10]) - passengers) + "," + Double.parseDouble(strings[11]);
    }
    public void setFare(Flight flight, int passengers){
        flight.setTotalFare(flight.getSecondClassFare() * passengers);
    }

}
