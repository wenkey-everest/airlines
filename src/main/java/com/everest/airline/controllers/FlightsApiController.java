package com.everest.airline.controllers;

import com.everest.airline.database.DataReader;
import com.everest.airline.exceptions.FileNotFoundException;
import com.everest.airline.exceptions.FileNotWrittenException;
import com.everest.airline.model.CreateFlight;
import com.everest.airline.model.Flight;
import com.everest.airline.model.SortingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FlightsApiController {


    @Autowired
    public DataReader dataReader;


    @GetMapping({"/flights/{number}", "/flights"})
    public List<Flight> getAllFlights(@PathVariable Optional<String> number) {

        return number.map(s -> dataReader.getFlightsList()
                .stream().filter(flight -> flight.getNumber() == Long.parseLong(s))
                .sorted(new SortingList())
                .collect(Collectors.toList()))
                .orElseGet(() -> dataReader.getFlightsList());
    }

    //     CUD
    @PostMapping("/flights")
    public Long create(String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeatsAvailable, String secondClassSeatsAvailable, String firstClassSeatsAvailable, String economicClassCapacity, String secondClassCapacity, String firstClassCapacity, String baseFare) {
        long latestId;
        List<Flight> flightsList = new DataReader().getFlightsList().stream().sorted(new SortingList()).collect(Collectors.toList());
        long lastId = flightsList.get(flightsList.size() - 1).getNumber();
        latestId = lastId + 1;
        Flight flight = new CreateFlight().CreateFlightForRestAPI(latestId, source, destination, departureDate, departureTime, arrivalDate, arrivalTime, availableSeats, economicSeatsAvailable, secondClassSeatsAvailable, firstClassSeatsAvailable, economicClassCapacity, secondClassCapacity, firstClassCapacity, baseFare);
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/"+latestId+".txt"))) {
                        bufferedWriter.write(flight.flightString(0,Integer.parseInt(economicSeatsAvailable),Integer.parseInt(firstClassSeatsAvailable),Integer.parseInt(secondClassSeatsAvailable)));
                        return flight.getNumber();
                    } catch (IOException e) {
                        throw new FileNotWrittenException(e);
                    }
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
