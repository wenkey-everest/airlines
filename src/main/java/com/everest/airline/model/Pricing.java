package com.everest.airline.model;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

public class Pricing {
    public double priceByDate(LocalDate departureDate, int availableSeats, int classCapacity, double basePrice){
        Duration duration = Duration.between(LocalDate.now().atStartOfDay(),departureDate.atStartOfDay());
        double classFare = priceBySeats(availableSeats,classCapacity,basePrice);
        Long beforeDate=duration.toDays();
        System.out.println(beforeDate);
        if(beforeDate>10)
            return classFare;
        else if(beforeDate>3)
            return classFare + (classFare * getIncrementer(departureDate,10,3,0.02));
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

    public double getIncrementer(LocalDate departureDate, int minDateToHike, int maxDateToHike, double incrementerValue){
        LocalDate date1 = departureDate.minusDays(minDateToHike);
        LocalDate date2 = departureDate.minusDays(maxDateToHike);
        double incrementer=0;
        incrementer = incrementer+incrementerValue;
        for(LocalDate date=date1;date.isBefore(date2);date=date.plusDays(1)){
            if(date.isEqual(LocalDate.now())){
                break;
            }
        }
        return incrementer;
    }

}
