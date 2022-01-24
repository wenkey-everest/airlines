package com.everest.airline.services;

import com.everest.airline.dbconfig.DbConfig;
import com.everest.airline.exceptions.FlightNotFoundException;
import com.everest.airline.exceptions.SeatsAvailabilityException;
import com.everest.airline.model.Flight;
import com.everest.airline.model.SortingList;
import com.everest.airline.model.FilterClass;
import com.everest.airline.resultextractors.GetFlight;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {


    public List<Flight> searchByFlight(String from, String to, String departureDate, String flightClass, String noOfPass) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new DbConfig().namedParameterJdbcTemplate().query("select * from flights", new GetFlight()).stream()
                .filter(flight -> {
                    if (flight.getSource().equalsIgnoreCase(from) &&
                            flight.getDestination().equalsIgnoreCase(to) &&
                            flight.getDepartureDate().format(formatter).equals(departureDate)) {
                       FilterClass filterClass = new FilterClass(noOfPass, flight, flightClass);
                        try {
                            return filterClass.filterFlightClass();
                        } catch (Exception e) {
                            throw new SeatsAvailabilityException(e);
                        }
                    } else
                        throw new FlightNotFoundException(flight.getDepartureDate());
                })
                .sorted(new SortingList())
                .collect(Collectors.toList());
    }
}
