package com.everest.airline.model;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

public class Pricing {
    public double priceByDate(LocalDate departureDate, int availableSeats, int classCapacity, double basePrice){
        Duration duration = Duration.between(departureDate.atStartOfDay(),LocalDate.now().atStartOfDay());
        double classFare = priceBySeats(availableSeats,classCapacity,basePrice);
        Long beforeDate=duration.toDays();
        if(beforeDate>15)
            return classFare;
        else if(beforeDate<10 && beforeDate>3){
            return classFare + (classFare * getIncrementer(departureDate,10,3,0.02));
        }

        else
            return classFare + (classFare * getIncrementer(departureDate,3,0,0.1));
    }

    public double priceBySeats(int availableSeats, int classCapacity, double basePrice){
        if(availableSeats>classCapacity*0.7)
            return basePrice;
        else if(availableSeats<classCapacity*0.7 && availableSeats>classCapacity*0.5)
            return basePrice + (basePrice*0.2);
        else if(availableSeats<classCapacity*0.5 && availableSeats>classCapacity*0.25)
            return basePrice + (basePrice*0.35);
        else
            return basePrice + (basePrice*0.5);
    }
    public double getIncrementer(LocalDate departureDate, int dateOneValue, int dateTwoValue, double incrementerValue){
        LocalDate date1 = LocalDate.now().minusDays(dateOneValue);
        LocalDate date2 = LocalDate.now().minusDays(dateTwoValue);
        double incrementer=0;
        for(LocalDate date=date1;date.isBefore(date2);date=date.plusDays(1)){
            if(date.isEqual(departureDate)){
                break;
            }
            incrementer = incrementer+incrementerValue;
        }
        return incrementer;
    }

}
