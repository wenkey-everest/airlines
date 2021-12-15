package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;

public class SecondClass extends FlightClass{
    private String[] strings;
    private int passengers;
    private String line;

    public SecondClass(int passengers, String flightClass, Flight flight, String[] strings) {
        super(passengers, flightClass, flight);
        this.passengers = passengers;
        this.strings = strings;
        setFare(flight, passengers);
    }
    @Override
    public String setLine() {
        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + strings[8] + "," + strings[9] + "," + (Integer.parseInt(strings[10]) - passengers) + "," + Double.parseDouble(strings[11]);
        return line;
    }

    public void setFare(Flight flight, int passengers) {
        flight.setTotalFare(flight.getSecondClassFare() * passengers);
    }

}
