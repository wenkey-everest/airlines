package com.everest.airline.model;

import com.everest.airline.flightClass.Economy;
import com.everest.airline.flightClass.FirstClass;
import com.everest.airline.flightClass.SecondClass;
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
                       new Economy(passengers,flightClass,flight, strings);
                        break;
                    case "firstClass":
                        new FirstClass(passengers,flightClass,flight,strings);
                        break;
                    case "secondClass":
                        new SecondClass(passengers,flightClass,flight,strings);
                        break;
                }
            }
        }
        return line;
    }

}
