package com.everest.airline.services;

import com.everest.airline.dbconfig.DbConfig;
import com.everest.airline.exceptions.NonThrowableException;
import com.everest.airline.exceptions.ThrowableException;
import com.everest.airline.model.Flight;
import com.everest.airline.actionfilters.SortingList;
import com.everest.airline.actionfilters.FilterClass;
import com.everest.airline.resultextractors.FlightRowMapper;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {

    public List<Flight> searchByFlight(String from, String to, String departureDate, String flightClass, String noOfPass) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new DbConfig().namedParameterJdbcTemplate().query("select * from flights", new FlightRowMapper()).stream()
                .filter(flight -> {
                    if (flight.getSource().equalsIgnoreCase(from) &&
                            flight.getDestination().equalsIgnoreCase(to) &&
                            flight.getDepartureDate().format(formatter).equals(departureDate)) {
                       FilterClass filterClass = new FilterClass(noOfPass, flight, flightClass);
                        try {
                            return filterClass.filterFlightClass();
                        } catch (Exception e) {
                            throw new ThrowableException("Number of passengers is greater than available seats", e);
                        }
                    } else
                        throw new NonThrowableException("Flight not found for date: "+flight.getDepartureDate());
                })
                .sorted(new SortingList())
                .collect(Collectors.toList());
    }

}
