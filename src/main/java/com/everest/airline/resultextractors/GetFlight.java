package com.everest.airline.resultextractors;

import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.SecondClass;
import com.everest.airline.model.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GetFlight implements RowMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        EconomyClass economyClass = new EconomyClass(rs.getInt("economic_seats_avaliable"),rs.getInt("economic_capacity"));
        FirstClass firstClass = new FirstClass(rs.getInt("firstclass_seats_avaliable"), rs.getInt("firstclass_capacity"));
        SecondClass secondClass = new SecondClass(rs.getInt("secondclass_seats_avaliable"), rs.getInt("secondclass_capacity"));
        return new Flight(rs.getLong("flight_number"), rs.getString("source"), rs.getString("destination"),rs.getDate("departure_date").toLocalDate(),rs.getTime("departure_time").toLocalTime(), rs.getDate("arrival_date").toLocalDate(), rs.getTime("arrival_time").toLocalTime(),  rs.getInt("available_seats"), economyClass, secondClass, firstClass, rs.getFloat("basefare"));
    }
}
