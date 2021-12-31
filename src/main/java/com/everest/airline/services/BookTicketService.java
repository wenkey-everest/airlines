package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.exceptions.FileNotWrittenException;
import com.everest.airline.model.FilterClass;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTicketService {

    @Autowired
    public FilterClass filterClass;

    @Autowired
    public DataReader dataReader;

    public List<Flight> bookTicket(String noOfPass, Long number, String flightClass) {
        return dataReader.getFlightsList()
                .stream().filter(flight -> flight.getNumber()==number)
                .map(flight -> {
                    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/"+flight.getNumber()+".txt"))) {
                        filterClass.filterFlightClass(flightClass, noOfPass, flight, number);
                        bufferedWriter.write(filterClass.getLine());
                        return flight;
                    } catch (IOException e) {
                        throw new FileNotWrittenException(e);
                    }
                })
                .collect(Collectors.toList());
    }

}
