package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.model.Flight;
import com.everest.airline.actionfilters.FilterClass;
import com.everest.airline.model.ClassProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTicketService {

    @Autowired
    private DataReader dataReader;

    public List<Flight> bookTicket(String noOfPass, Long number, String flightClass) {
        return dataReader.getAllFlights()
                .stream().filter(flight -> flight.getNumber() == number)
                .peek(flight -> {
                   FilterClass filterClass= new FilterClass(noOfPass,flight,flightClass);
                   ClassProp classProp = filterClass.classTypeMap().get(flightClass);
                   classProp.getFlightClassView().updateSeats(classProp.getDbColumnName());
                })
                .collect(Collectors.toList());
    }

}
