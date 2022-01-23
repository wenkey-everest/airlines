package com.everest.airline.flightClassViews;

import com.everest.airline.config.DbConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class SecondClass implements FlightClass{
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int secondClassSeatsAvailable;
    private double secondClassFare;
    private int secondClassCapacity;

    public SecondClass(int secondClassSeatsAvailable, int secondClassCapacity) {
        this.secondClassSeatsAvailable = secondClassSeatsAvailable;
        this.secondClassCapacity = secondClassCapacity;
    }

    public SecondClass(int passengers, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }

    @Override
    public void setLine() {
        NamedParameterJdbcTemplate jdbcTemplate = new DbConfig().namedParameterJdbcTemplate();
        int secondClassSeats = flight.getSecondClass().getSecondClassSeatsAvailable()- passengers;
        int avaliableSeats = flight.getAvailableSeats()-passengers;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("secondClassSeats",secondClassSeats)
                .addValue("number", flight.getNumber())
                .addValue("availableSeats", avaliableSeats);
        String sql = "update flights set secondclass_seats_avaliable=:secondClassSeats, available_seats=:availableSeats where flight_number=:number";
        jdbcTemplate.update(sql,sqlParameterSource);
    }

    @Override
    public void totalCost(int passengers) {
        totalCost = classFareBySeats()*passengers;
        flight.setTotalFare(totalCost);
    }

    @Override
    public double classFareBySeats(){
        Pricing pricing = new Pricing();
        double classFare= pricing.priceByDate(flight.getDepartureDate(),flight.getSecondClass().getSecondClassSeatsAvailable(),flight.getSecondClass().getSecondClassCapacity(),(flight.getBaseFare()*1.5));
        flight.getSecondClass().setSecondClassFare(classFare);
        return classFare;
    }

    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getSecondClass().getSecondClassSeatsAvailable();
    }

    public void setSecondClassFare(double secondClassFare) {
        this.secondClassFare = secondClassFare;
    }

    public int getSecondClassSeatsAvailable() {
        return secondClassSeatsAvailable;
    }

    public double getSecondClassFare() {
        return secondClassFare;
    }

    public int getSecondClassCapacity() {
        return secondClassCapacity;
    }
}
