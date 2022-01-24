package com.everest.airline.dbconfig;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DbConfig {
    private String url = "jdbc:mysql://127.0.0.1:3306/flights_database";
    private String user = "root";
    private String password = "";

    public DataSource flightDataSource() {
        return new DriverManagerDataSource(url, user, password);
    }

    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(flightDataSource());
    }

}
