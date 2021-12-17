package com.everest.airline.flightClassViews;

import com.everest.airline.model.Flight;

public class FirstClass extends FlightClass {
    private String[] strings;
    private int passengers;
    private String line;
    private Flight flight;
    public FirstClass(int passengers, String flightClass, Flight flight, String[] strings) {
        super(passengers, flightClass, flight);
        this.passengers = passengers;
        this.strings = strings;
        this.flight=flight;
        setFare(flight, passengers);
    }
    @Override
    public String setLine() {
        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + Integer.parseInt(strings[7]) + "," + Integer.parseInt(strings[8]) + "," + strings[9] + "," + strings[10] + "," + Double.parseDouble(strings[11]);
        if(flight.getEconomicSeats()>passengers)
        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + strings[8] + "," + (Integer.parseInt(strings[9]) - passengers) + "," + strings[10] + "," + Double.parseDouble(strings[11]);
        else try {
            throw new Exception("enter valid number to book");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public void setFare(Flight flight, int passengers) {
        flight.setTotalFare(flight.getSecondClassFare() * passengers);
    }
}
