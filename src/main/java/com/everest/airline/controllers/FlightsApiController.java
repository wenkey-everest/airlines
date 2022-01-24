package com.everest.airline.controllers;

import com.everest.airline.dbconfig.DbConfig;
import com.everest.airline.model.Flight;
import com.everest.airline.resultextractors.FlightRowMapper;
import com.everest.airline.resultextractors.LastIndexRowMapper;
import com.everest.airline.resultextractors.SqlParamMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class FlightsApiController {

    private final DbConfig dbConfig = new DbConfig();

    private final NamedParameterJdbcTemplate npJdbcTemplate = dbConfig.namedParameterJdbcTemplate();

    @GetMapping({"/flights/{number}", "/flights"})
    public List<Flight> getAllFlights(@PathVariable Optional<String> number) {
        if (number.isPresent()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("number", number.get());
            return npJdbcTemplate.query("select * from flights where flight_number = :number", map, new FlightRowMapper());
        } else
            return npJdbcTemplate.query("select * from flights", new FlightRowMapper());
    }

    //     CUD
    @PostMapping("/flights")
    public ResponseEntity<String> create(String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        List<Long> value = npJdbcTemplate.query("select max(flight_number) from flights", new LastIndexRowMapper());
        SqlParameterSource sqlParamMap = new SqlParamMap().sqlParameterMap(value.get(0) + 1, source, destination, departureDate, departureTime, arrivalDate, arrivalTime, availableSeats, economicSeatsAvailable, secondClassSeatsAvailable, firstClassSeatsAvailable, economicClassCapacity, secondClassCapacity, firstClassCapacity, baseFare);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insertSql = "INSERT INTO flights VALUES (:flight_number,:source,:destination,:departure_date, :departure_time," +
                ":arrival_date,:arrival_time,:available_seats,:economic_seats_avaliable,:secondclass_seats_avaliable,:firstclass_seats_avaliable," +
                ":economic_capacity,:secondclass_capacity,:firstclass_capacity,:basefare)";
        npJdbcTemplate.update(insertSql, sqlParamMap, keyHolder);
        return new ResponseEntity<>("Inserted Successfully", HttpStatus.OK);
    }

    // Update
    @PutMapping("/flights/{number}")
    public ResponseEntity<String> update(@PathVariable("number") long number, String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        SqlParameterSource sqlParamMap = new SqlParamMap().sqlParameterMap(number, source, destination, departureDate, departureTime, arrivalDate, arrivalTime, availableSeats, economicSeatsAvailable, secondClassSeatsAvailable, firstClassSeatsAvailable, economicClassCapacity, secondClassCapacity, firstClassCapacity, baseFare);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String insertSql = "update flights set source=:source,destination=:destination,departure_date=:departure_date, departure_time = :departure_time," +
                "arrival_date=:arrival_date,arrival_time=:arrival_time, available_seats=:available_seats,economic_seats_avaliable=:economic_seats_avaliable,secondclass_seats_avaliable=:secondclass_seats_avaliable,firstclass_seats_avaliable=:firstclass_seats_avaliable," +
                "economic_capacity=:economic_capacity,secondclass_capacity=:secondclass_capacity,firstclass_capacity=:firstclass_capacity,basefare=:basefare where  flight_number = :number";
        npJdbcTemplate.update(insertSql, sqlParamMap, keyHolder);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);

    }

    // Update
    @DeleteMapping("/flights/{number}")
    public ResponseEntity<String> delete(@PathVariable long number) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("number", number);
        String deleteQuery = "delete from flights where flight_number = :number";
        npJdbcTemplate.update(deleteQuery, parameterSource);
        return new ResponseEntity<>("record Deleted", HttpStatus.OK);
    }
}
