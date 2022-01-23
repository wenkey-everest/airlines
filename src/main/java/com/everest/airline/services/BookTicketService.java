package com.everest.airline.services;

import com.everest.airline.config.DbConfig;
import com.everest.airline.model.FilterClass;
import com.everest.airline.model.Flight;
import com.everest.airline.resultextractors.GetFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTicketService {

    @Autowired
    public FilterClass filterClass;

    public List<Flight> bookTicket(String noOfPass, Long number, String flightClass) {
        NamedParameterJdbcTemplate jdbcTemplate = new DbConfig().namedParameterJdbcTemplate();
        return jdbcTemplate.query("select * from flights", new GetFlight())
                .stream().filter(flight -> flight.getNumber()==number)
                .peek(flight->filterClass.filterFlightClass(flightClass, noOfPass, flight, number))
                .collect(Collectors.toList());
    }

}
