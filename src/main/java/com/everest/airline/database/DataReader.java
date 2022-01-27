package com.everest.airline.database;

import com.everest.airline.config.AppConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.resultextractors.FlightRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataReader {
    public List<Flight> getAllFlights(){
        return new AppConfig().namedParameterJdbcTemplate()
                .query("select * from flights", new FlightRowMapper());
    }
}
