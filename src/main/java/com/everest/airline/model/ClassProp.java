package com.everest.airline.model;

public class ClassProp {
    private String dbColumnName;
    private FlightClassView flightClassView;

    public ClassProp(String dbColumnName, FlightClassView flightClassView) {

        this.dbColumnName = dbColumnName;
        this.flightClassView = flightClassView;
    }

    public String getDbColumnName() {
        return dbColumnName;
    }

    public FlightClassView getFlightClassView() {
        return flightClassView;
    }
}
