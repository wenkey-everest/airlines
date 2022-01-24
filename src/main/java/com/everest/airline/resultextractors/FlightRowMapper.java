package com.everest.airline.resultextractors;

import com.everest.airline.exceptions.ThrowableException;
import com.everest.airline.model.Flight;
import com.everest.airline.model.ClassSeats;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FlightRowMapper implements RowMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            ClassSeats economyClass = new ClassSeats(rs.getInt("economic_seats_avaliable"), rs.getInt("economic_capacity"));
            ClassSeats firstClass = new ClassSeats(rs.getInt("firstclass_seats_avaliable"), rs.getInt("firstclass_capacity"));
            ClassSeats secondClass = new ClassSeats(rs.getInt("secondclass_seats_avaliable"), rs.getInt("secondclass_capacity"));
            return new Flight(rs.getLong("flight_number"), rs.getString("source"), rs.getString("destination"), rs.getDate("departure_date").toLocalDate(), rs.getTime("departure_time").toLocalTime(), rs.getDate("arrival_date").toLocalDate(), rs.getTime("arrival_time").toLocalTime(), rs.getInt("available_seats"), economyClass, secondClass, firstClass, rs.getFloat("basefare"));
        } catch (Exception e) {
            throw new ThrowableException("Database is empty, Please insert database in dbConfig", e);
        }
    }
}
