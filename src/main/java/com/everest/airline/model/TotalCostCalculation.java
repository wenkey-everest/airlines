package com.everest.airline.model;

import com.everest.airline.enums.ClassFare;
import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.FlightClass;
import com.everest.airline.flightClassViews.SecondClass;
import org.springframework.stereotype.Component;

@Component
public class TotalCostCalculation {

    public double totalCost(String classType, int passengerCount)
    {
        double totalCost;
        switch (classType) {
            case "economic":
                totalCost = ClassFare.ECONOMIC.getCost()*passengerCount;
                break;
            case "firstClass":
                totalCost= ClassFare.FIRSTCLASS.getCost()*passengerCount;
                break;
            case "secondClass":
               totalCost = ClassFare.SECONDCLASS.getCost()*passengerCount;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + classType);
        }
        return totalCost;
    }
}
