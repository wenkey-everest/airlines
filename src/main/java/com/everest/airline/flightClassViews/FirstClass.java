package com.everest.airline.flightClassViews;

import com.everest.airline.config.DbConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class FirstClass implements FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int firstClassSeatsAvailable;
    private double firstClassFare;
    private int firstClassCapacity;

    public FirstClass(int firstClassSeatsAvailable, int firstClassCapacity) {
        this.firstClassSeatsAvailable = firstClassSeatsAvailable;
        this.firstClassCapacity = firstClassCapacity;
    }

    public FirstClass(int passengers, Flight flight) {
        this.passengers = passengers;
        this.flight=flight;
    }
    @Override
    public void setLine() {
        NamedParameterJdbcTemplate jdbcTemplate = new DbConfig().namedParameterJdbcTemplate();
        int firstClass = flight.getFirstClass().getFirstClassSeatsAvailable() - passengers;
        int avaliableSeats = flight.getAvailableSeats()-passengers;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("firstClassSeatsAvaliable",firstClass)
                .addValue("number", flight.getNumber())
                .addValue("availableSeats", avaliableSeats);
        String sql = "update flights set firstclass_seats_avaliable=:firstClassSeatsAvaliable, available_seats=:availableSeats where flight_number=:number";
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
        double classFare=pricing.priceByDate(flight.getDepartureDate(),flight.getFirstClass().getFirstClassSeatsAvailable(),flight.getFirstClass().getFirstClassCapacity(),(flight.getBaseFare()*2));
        flight.getFirstClass().setFirstClassFare(classFare);
        return classFare;
    }

    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getFirstClass().getFirstClassSeatsAvailable();
    }


    public void setFirstClassFare(double firstClassFare) {
        this.firstClassFare = firstClassFare;
    }

    public int getFirstClassSeatsAvailable() {
        return firstClassSeatsAvailable;
    }

    public double getFirstClassFare() {
        return firstClassFare;
    }

    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }
}
