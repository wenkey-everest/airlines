package com.everest.airline.services;

import com.everest.airline.dbconfig.DbConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.actionfilters.FilterClass;
import com.everest.airline.resultextractors.FlightRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTicketService {


    public List<Flight> bookTicket(String noOfPass, Long number, String flightClass) {
        NamedParameterJdbcTemplate jdbcTemplate = new DbConfig().namedParameterJdbcTemplate();
        return jdbcTemplate.query("select * from flights", new FlightRowMapper())
                .stream().filter(flight -> flight.getNumber() == number)
                .peek(flight -> new FilterClass(noOfPass,flight,flightClass).testExecute())
                .collect(Collectors.toList());
    }

}
