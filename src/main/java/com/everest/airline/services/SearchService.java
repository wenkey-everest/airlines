package com.everest.airline.services;
import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchService {

    public List<Flight> searchByFlight(String from, String to, String departureDate){
        return Data.getFlights().parallelStream()
                .filter(s->(s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                .collect(Collectors.toList());
    }

}
