package com.everest.airline.model;

import java.util.HashMap;
import java.util.Map;

public class FilterClass {


    private FlightClassView economic;
    private FlightClassView firstClass;
    private FlightClassView secondClass;
    private String flightClass;
    private int passengers;

    public FilterClass(String noOfPass, Flight flight, String flightClass) {
        this.flightClass = flightClass;
        this.passengers = Integer.parseInt(noOfPass);
        this.economic = new FlightClassView(passengers, flight.getEconomyClass(), flight);
        this.firstClass = new FlightClassView(passengers, flight.getEconomyClass(), flight);
        this.secondClass = new FlightClassView(passengers, flight.getSecondClass(), flight);
    }

    public boolean filterFlightClass() {
        boolean check = false;
        switch (flightClass) {
            case "economic":
                check = economic.validateSeats(passengers);
                economic.totalCost(passengers);
                break;
            case "firstClass":
                check = firstClass.validateSeats(passengers);
                firstClass.totalCost(passengers);
                break;
            case "secondClass":
                check = secondClass.validateSeats(passengers);
                secondClass.totalCost(passengers);
                break;
        }
        return check;
    }

    private Map<String, String> dbColumnNameMap() {
        Map<String, String> dbColumnNameMap = new HashMap<>();
        dbColumnNameMap.put("economic", "economic_seats_avaliable");
        dbColumnNameMap.put("firstClass", "firstclass_seats_avaliable");
        dbColumnNameMap.put("secondClass", "secondclass_seats_avaliable");
        return dbColumnNameMap;
    }

    private Map<String, FlightClassView> FlightClassMap() {
        Map<String, FlightClassView> FlightClassMap = new HashMap<>();
        FlightClassMap.put("economic", economic);
        FlightClassMap.put("firstClass", firstClass);
        FlightClassMap.put("secondClass", secondClass);
        return FlightClassMap;
    }

    public void testExecute() {
        FlightClassMap().get(flightClass).updateSeats(dbColumnNameMap().get(flightClass));
    }

}
