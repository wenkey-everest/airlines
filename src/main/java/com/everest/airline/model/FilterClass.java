package com.everest.airline.model;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.FlightClass;
import com.everest.airline.flightClassViews.SecondClass;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FilterClass {
    public String filterFlightClass(String flightClass, String[] strings, String line, String noOfPass, List<Flight> flightList, Long number) {
        int passengers = Integer.parseInt(noOfPass);
        for(Flight flight:flightList) {
            if (number.equals(flight.getNumber())) {
                switch (flightClass) {
                    case "economic":
                        FlightClass economyClass= new EconomyClass(passengers, flightClass, flight, strings);
                        line= economyClass.setLine();
                        break;
                    case "firstClass":
                       FlightClass firstClass= new FirstClass(passengers,flightClass,flight,strings);
                       line=firstClass.setLine();
                        break;
                    case "secondClass":
                        FlightClass secondClass=new SecondClass(passengers,flightClass,flight,strings);
                        line= secondClass.setLine();
                        break;
                }
            }
        }
        return line;
    }

}
