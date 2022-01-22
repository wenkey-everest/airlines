package com.everest.airline.config;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DbConfig {
    private String url = "jdbc:mysql://127.0.0.1:3306/flights_database";
    private String user = "root";
    private String password= "";

    public DataSource flightDataSource(){
        return new DriverManagerDataSource(url,user,password);
    }


}
