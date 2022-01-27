package com.everest.airline.actionfilters;

import com.everest.airline.enums.ClassType;
import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightClassView;
import com.everest.airline.model.ClassProp;

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
        this.firstClass = new FlightClassView(passengers, flight.getFirstClass(), flight);
        this.secondClass = new FlightClassView(passengers, flight.getSecondClass(), flight);
    }

    public Map<String, ClassProp> classTypeMap() {
        Map<String, ClassProp> flightClassMap = new HashMap<>();
        flightClassMap.put(ClassType.ECONOMIC.getString(), new ClassProp("economic_seats_avaliable", economic));
        flightClassMap.put(ClassType.FIRSTCLASS.getString(), new ClassProp("firstclass_seats_avaliable", firstClass));
        flightClassMap.put(ClassType.SECONDCLASS.getString(), new ClassProp("secondclass_seats_avaliable", secondClass));
        return flightClassMap;
    }

}
