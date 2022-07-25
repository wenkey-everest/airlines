package com.everest.airline.resultextractors;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class SqlParamMap {
    public SqlParameterSource sqlParameterMap(Long flight_number, String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        return new MapSqlParameterSource()
                .addValue("flight_number", flight_number)
                .addValue("source", source)
                .addValue("destination", destination)
                .addValue("departure_date", departureDate)
                .addValue("departure_time", departureTime)
                .addValue("arrival_date", arrivalDate)
                .addValue("arrival_time", arrivalTime)
                .addValue("available_seats", availableSeats)
                .addValue("economic_seats_avaliable", economicSeatsAvailable)
                .addValue("secondclass_seats_avaliable", secondClassSeatsAvailable)
                .addValue("firstclass_seats_avaliable", firstClassSeatsAvailable)
                .addValue("economic_capacity", economicClassCapacity)
                .addValue("secondclass_capacity", secondClassCapacity)
                .addValue("firstclass_capacity", firstClassCapacity)
                .addValue("basefare", baseFare);
    }
}
