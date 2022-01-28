package com.everest.airline.actionfilters;

import com.everest.airline.enums.ClassType;
import com.everest.airline.model.ClassProp;
import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightClassView;

import java.util.EnumMap;
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

    public ClassProp classTypeMap() {
        Map<ClassType, ClassProp> flightClassMap = new HashMap<>();
        flightClassMap.put(ClassType.ECONOMIC, new ClassProp(ClassType.ECONOMIC.getString(), economic));
        flightClassMap.put(ClassType.FIRSTCLASS, new ClassProp(ClassType.FIRSTCLASS.getString(), firstClass));
        flightClassMap.put(ClassType.SECONDCLASS, new ClassProp(ClassType.SECONDCLASS.getString(), secondClass));
        return flightClassMap.get(ClassType.valueOf(flightClass));
    }

}
