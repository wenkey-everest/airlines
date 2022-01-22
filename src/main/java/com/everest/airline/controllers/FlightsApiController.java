package com.everest.airline.controllers;

import com.everest.airline.config.DbConfig;
import com.everest.airline.database.DataParser;
import com.everest.airline.database.DataReader;
import com.everest.airline.exceptions.FileNotFoundException;
import com.everest.airline.exceptions.FileNotWrittenException;
import com.everest.airline.model.CreateFlight;
import com.everest.airline.model.Flight;
import com.everest.airline.model.SortingList;
import com.everest.airline.resultextractors.GetFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FlightsApiController {

    @Autowired
    public DataReader dataReader;

    private final NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(new DbConfig().flightDataSource());

    @GetMapping({"/flights/{number}", "/flights"})
    public List<Flight> getAllFlights(@PathVariable Optional<String> number) {
        if(number.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("number", number.get());
             return npJdbcTemplate.query("select * from flights where flight_number = :number", map, new GetFlight());
        }else
        return npJdbcTemplate.query("select * from flights", new GetFlight());
    }

    //     CUD
    @PostMapping("/flights")
    public int create(String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        List<Flight> flightsList = new DataReader().getFlightsList().stream().sorted(new SortingList()).collect(Collectors.toList());
        long lastId = flightsList.get(flightsList.size() - 1).getNumber();
        HashMap<String , Object> paramMap = new HashMap<>(){{
            put("flight_number",  lastId+1);
            put("source", source);
            put("destination", destination);
            put("departure_date", departureDate);
            put("departure_time", departureTime);
            put("arrival_date", arrivalDate);
            put("arrival_time", arrivalTime);
            put("avaliable_seats", availableSeats);
            put("economic_seats_avaliable", economicSeatsAvailable);
            put("secondclass_seats_avaliable", secondClassSeatsAvailable);
            put("firstclass_seats_avaliable", firstClassSeatsAvailable);
            put("economic_capacity", economicClassCapacity);
            put("secondclass_capacity", secondClassCapacity);
            put("firstclass_capacity", firstClassCapacity);
            put("basefare", baseFare);
        }};

        String insertSql = "INSERT INTO flights VALUES (:flight_number,:source,:destination,:departure_date, :departure_time," +
                ":arrival_date,:arrival_time,:avaliable_seats,:economic_seats_avaliable,:secondclass_seats_avaliable,:firstclass_seats_avaliable," +
                ":economic_capacity,:secondclass_capacity,:firstclass_capacity,:basefare)";
        return npJdbcTemplate.update(insertSql,paramMap);

                }
    // Update
    @PutMapping("/flights/{number}")
    public Flight update(@PathVariable("number") long number,String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        Flight flight = new CreateFlight().CreateFlightForRestAPI(number, source, destination, departureDate, departureTime, arrivalDate, arrivalTime, availableSeats, economicSeatsAvailable, secondClassSeatsAvailable, firstClassSeatsAvailable, economicClassCapacity, secondClassCapacity, firstClassCapacity, baseFare);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" + number + ".txt"));) {
            bufferedWriter.write(flight.flightString(0,Integer.parseInt(economicSeatsAvailable),Integer.parseInt(firstClassSeatsAvailable),Integer.parseInt(secondClassSeatsAvailable)));
            return flight;
        } catch (IOException e) {
            throw new FileNotFoundException(e);
        }
    }

    // Update
    @DeleteMapping("/flights/{number}")
    public void delete(@PathVariable long number) {
        File file = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" + number + ".txt");
        file.delete();

    }
}
