package com.everest.airline.flightClassViews;

import com.everest.airline.config.DbConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.model.Pricing;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class EconomyClass implements FlightClass {
    private int passengers;
    private String line;
    private Flight flight;
    private double totalCost;
    private int economicSeatsAvailable;
    private double economicClassFare;
    private int economicClassCapacity;

    public EconomyClass(int economicSeatsAvailable, int economicClassCapacity) {
        this.economicSeatsAvailable = economicSeatsAvailable;
        this.economicClassCapacity = economicClassCapacity;
    }

    public EconomyClass(int passengers, Flight  flight) {
        this.passengers = passengers;
        this.flight=flight;
    }

    @Override
    public String setLine() {
        NamedParameterJdbcTemplate jdbcTemplate = new DbConfig().namedParameterJdbcTemplate();
        int economicSeats = flight.getEconomyClass().getEconomicSeatsAvailable()- passengers;
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("economicSeatsAvaliable",economicSeats)
                .addValue("number", flight.getNumber());
        String sql = "update flights set economic_seats_avaliable=:economicSeatsAvaliable where flight_number=:number";
        jdbcTemplate.update(sql,sqlParameterSource);
        return line;
    }
    @Override
    public void totalCost(int passengers) {
        totalCost = classFareBySeats()*passengers;
        flight.setTotalFare(totalCost);
    }
    @Override
    public double classFareBySeats(){
        Pricing pricing = new Pricing();
        double classFare= pricing.priceByDate(flight.getDepartureDate(),flight.getEconomyClass().getEconomicSeatsAvailable(),flight.getEconomyClass().getEconomicClassCapacity(),flight.getBaseFare());
        flight.getEconomyClass().setEconomicClassFare(classFare);
        return classFare;
    }
    @Override
    public boolean validateSeats(int noOfPass) {
        return noOfPass < flight.getEconomyClass().getEconomicSeatsAvailable();
    }

    public void setEconomicClassFare(double economicClassFare) {
        this.economicClassFare = economicClassFare;
    }

    public int getEconomicSeatsAvailable() {
        return economicSeatsAvailable;
    }

    public double getEconomicClassFare() {
        return economicClassFare;
    }

    public int getEconomicClassCapacity() {
        return economicClassCapacity;
    }
}


