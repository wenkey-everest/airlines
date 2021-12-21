package com.everest.airline.model;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.FlightClass;
import com.everest.airline.flightClassViews.SecondClass;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FilterClass {

    private String line;
    private double totalCost;
    private boolean check;
    public void filterFlightClass(String flightClass, String noOfPass, List<Flight> flightList, Long number, int economicSeats, int firstClassSeats, int secondClassSeats) {
        int passengers = Integer.parseInt(noOfPass);
        for(Flight flight:flightList) {
            if (number.equals(flight.getNumber())) {
                switch (flightClass) {
                    case "economic":
                        FlightClass economyClass = new EconomyClass(passengers, flightClass, flight);
                        check = validateSeats(passengers,economicSeats);
                        totalCost=economyClass.totalCost(passengers);
                        line= economyClass.setLine();
                        break;
                    case "firstClass":
                       FlightClass firstClass = new FirstClass(passengers,flightClass,flight);
                        check = validateSeats(passengers,firstClassSeats);
                        totalCost=firstClass.totalCost(passengers);
                        line=firstClass.setLine();
                        break;
                    case "secondClass":
                        FlightClass secondClass = new SecondClass(passengers,flightClass,flight);
                        check = validateSeats(passengers,secondClassSeats);
                        totalCost=secondClass.totalCost(passengers);
                        line=secondClass.setLine();
                        break;
                }
            }
        }
    }


    public boolean validateSeats(int passengerCount,int availableSeats) {
        return passengerCount < availableSeats;
    }

    public boolean isCheck() {
        return check;
    }

    public String getLine() {
        return line;
    }

    public double getTotalCost() {
        return totalCost;
    }

}
