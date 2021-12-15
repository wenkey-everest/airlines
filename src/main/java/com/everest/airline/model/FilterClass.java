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
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + (Integer.parseInt(strings[8]) - passengers) + "," + strings[9] + "," + strings[10] + "," + Double.parseDouble(strings[11]);
                        new EconomyClass(passengers,flightClass,flight, strings);
                        break;
                    case "firstClass":
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + strings[8] + "," + (Integer.parseInt(strings[9]) - passengers) + "," + strings[10] + "," + Double.parseDouble(strings[11]);
                        new FirstClass(passengers,flightClass,flight,strings);
                        break;
                    case "secondClass":
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - passengers) + "," + strings[8] + "," + strings[9] + "," + (Integer.parseInt(strings[10]) - passengers) + "," + Double.parseDouble(strings[11]);
                        new SecondClass(passengers,flightClass,flight,strings);
                        break;
                }
            }
        }
        return line;
    }

}
