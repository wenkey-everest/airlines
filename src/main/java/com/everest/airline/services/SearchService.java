package com.everest.airline.services;
import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private final String from;
    private final String to;
    private final String departureDate;
    public SearchService(String from, String to, String departureDate) {
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
    }

    public List<Flight> searchByFlight(){
        return Data.getFlights().parallelStream()
                .filter(s->(s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                .collect(Collectors.toList());
    }

}
