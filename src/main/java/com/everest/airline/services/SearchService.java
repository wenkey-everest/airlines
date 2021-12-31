package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.database.DataReader;
import com.everest.airline.exceptions.FlightNotFoundException;
import com.everest.airline.exceptions.SeatsAvailabilityException;
import com.everest.airline.model.FilterClass;
import com.everest.airline.model.Flight;
import com.everest.airline.model.SortingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {

    @Autowired
    public FilterClass filterClass;

    @Autowired
    public DataReader dataReader;

    public List<Flight> searchByFlight(String from, String to, String departureDate, String flightClass, String noOfPass) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dataReader.getFlightsList().stream()
                .filter(flight -> {
                    try {
                        if (flight.getSource().equalsIgnoreCase(from) && flight.getDestination().equalsIgnoreCase(to) && flight.getDepartureDate().format(formatter).equals(departureDate)) {
                            filterClass.filterFlightClass(flightClass, noOfPass, flight, flight.getNumber());
                            try {
                                return filterClass.isCheck();
                            } catch (Exception e) {
                                throw new SeatsAvailabilityException(e);
                            }
                        }
                        return false;
                    } catch (Exception e) {
                        throw new FlightNotFoundException(flight.getDepartureDate());
                    }
                })
                .sorted(new SortingList())
                .collect(Collectors.toList());
    }
}
