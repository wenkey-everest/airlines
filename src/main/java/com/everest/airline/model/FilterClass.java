package com.everest.airline.model;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.FlightClass;
import com.everest.airline.flightClassViews.SecondClass;
import org.springframework.stereotype.Component;
@Component
public class FilterClass {

    private String line;
    private boolean check;
    public void filterFlightClass(String flightClass, String noOfPass, Flight flight, Long number) {
        int passengers = Integer.parseInt(noOfPass);
            if (number.equals(flight.getNumber())) {
                switch (flightClass) {
                    case "economic":
                        FlightClass economyClass = new EconomyClass(passengers, flight);
                        check = economyClass.validateSeats(passengers);
                        economyClass.setLine();
                        economyClass.totalCost(passengers);
                        break;
                    case "firstClass":
                       FlightClass firstClass = new FirstClass(passengers,flight);
                        check = firstClass.validateSeats(passengers);
                        firstClass.setLine();
                        firstClass.totalCost(passengers);
                        break;
                    case "secondClass":
                        FlightClass secondClass = new SecondClass(passengers,flight);
                        check = secondClass.validateSeats(passengers);
                        secondClass.setLine();
                        secondClass.totalCost(passengers);
                        break;
                }
            }
    }

    public boolean isCheck() {
        return check;
    }

}
