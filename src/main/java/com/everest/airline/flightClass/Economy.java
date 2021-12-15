package com.everest.airline.flightClass;

import com.everest.airline.model.Flight;

public class Economy extends FlightClass {
    private String line;
    private String[] strings;
    private int passengers;
    public Economy(int passengers,String flightClass, Flight flight,String[] strings) {
        super(passengers, flightClass, flight);
        this.passengers=passengers;
        this.strings=strings;
        setLine();
        setFare(flight,passengers);
    }

    public void setLine(){
        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + (Integer.parseInt(strings[8]) - passengers) + "," + strings[9] + "," + strings[10] + "," + Double.parseDouble(strings[11]);
    }

    public void setFare(Flight flight, int passengers){
        flight.setTotalFare(flight.getSecondClassFare() * passengers);
    }
}
