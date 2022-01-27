package com.everest.airline.model;

import com.everest.airline.config.AppConfig;
import com.everest.airline.stratergies.PricingStrategy;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class FlightClassView {
    private int passengers;
    private double totalCost;
    private ClassSeats flightClass;
    private Flight flight;

    public FlightClassView(int passengers, ClassSeats flightClass, Flight flight) {
        this.passengers = passengers;
        this.flightClass = flightClass;
        this.flight = flight;
    }

    public int updateSeats(String dbColumn) {
        NamedParameterJdbcTemplate jdbcTemplate = new AppConfig().namedParameterJdbcTemplate();
        int classSeats = flightClass.getSeatsAvailable() - passengers;
        int avaliableSeats = flight.getAvailableSeats() - passengers;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("SeatsAvailable", classSeats)
                .addValue("number", flight.getNumber())
                .addValue("availableSeats", avaliableSeats);
        String sql = "update flights set " + dbColumn + "=:SeatsAvailable, available_seats=:availableSeats where flight_number=:number";
        return jdbcTemplate.update(sql, sqlParameterSource);
    }

    public void totalCost(String passengers) {
        totalCost = classFareBySeats() * Integer.parseInt(passengers);
        flight.setTotalFare(totalCost);
    }

    public double classFareBySeats() {
        PricingStrategy pricingStrategy = new PricingStrategy();
        double classFare = pricingStrategy.priceByDate(flight.getDepartureDate(), flightClass.getSeatsAvailable(), flightClass.getClassCapacity(), flight.getBaseFare());
        flightClass.setClassFare(classFare);
        return classFare;
    }

    public boolean validateSeats(String noOfPass) {
        return Integer.parseInt(noOfPass) < flightClass.getSeatsAvailable();
    }

}
