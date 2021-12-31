package com.everest.airline.model;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.SecondClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateFlight {

    public Flight CreateFlightForRestAPI(Long number, String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare ) {
        EconomyClass economyClass = new EconomyClass(Integer.parseInt(economicSeatsAvailable), Integer.parseInt(economicClassCapacity));
        FirstClass firstClass = new FirstClass(Integer.parseInt(firstClassSeatsAvailable), Integer.parseInt(firstClassCapacity));
        SecondClass secondClass = new SecondClass(Integer.parseInt(secondClassSeatsAvailable), Integer.parseInt(secondClassCapacity));
        return new Flight(number, source , destination, LocalDate.parse(departureDate), LocalTime.parse(departureTime),  LocalDate.parse(arrivalDate), LocalTime.parse(arrivalTime),  Integer.parseInt(availableSeats), economyClass, secondClass, firstClass, Double.parseDouble(baseFare));
    }
}
