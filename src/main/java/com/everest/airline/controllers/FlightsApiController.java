package com.everest.airline.controllers;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.everest.airline.database.DataParser;
import com.everest.airline.database.DataReader;
import com.everest.airline.model.Flight;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@RestController
public class FlightsApiController {
    private List<Flight> flightsList = new DataReader().getFlightsList();
    private static List<Long> deletedFlightIds = new ArrayList<>();

    @GetMapping("/flights")
    public List<Flight> getAllFlights(@PathVariable Optional<String> number) {
        return flightsList;
    }

    //     CUD
    @PostMapping("/flights")
    public long create(String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeats, String secondClassSeats, String firstClassSeats, String economicSeatsCapacity, String secondClassSeatsCapacity, String firstClassSeatsCapacity, String baseFare) {
        // 1009 = Get the last flight id
        long latestId;
        long lastId = flightsList.get(flightsList.size() - 1).getNumber();
        latestId = lastId + 1;
        Flight flight = new Flight(latestId, source, destination,
                LocalDate.parse(departureDate), LocalTime.parse(departureTime),
                LocalDate.parse(arrivalDate), LocalTime.parse(arrivalTime),
                Integer.parseInt(availableSeats), Integer.parseInt(economicSeats),
                Integer.parseInt(firstClassSeats), Integer.parseInt(secondClassSeats),
                Integer.parseInt(economicSeatsCapacity), Integer.parseInt(firstClassSeatsCapacity),
                Integer.parseInt(secondClassSeatsCapacity),
                Double.parseDouble(baseFare));
        try {
            for (File file : DataParser.multiFileReader()) {
                if (file.getName().endsWith(".txt")) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    if (!bufferedReader.readLine().contains(String.valueOf(lastId))) {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" + latestId + ".txt"));
                        String flightLine = latestId + "," + source + "," + destination + "," + departureDate + "," + departureTime + "," + arrivalDate + "," + arrivalTime + "," + availableSeats + "," + economicSeats + "," + secondClassSeats + "," + firstClassSeats + "," + economicSeatsCapacity + "," + secondClassSeatsCapacity + "," + firstClassSeatsCapacity + "," + baseFare;
                        bufferedWriter.write(flightLine);
                        bufferedWriter.close();
                    }
                }
            }
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        flightsList.add(flight);
        return flight.getNumber();
    }

    // Update
    @PutMapping("/flights/{number}")
    public Flight update(@PathVariable("number") long number, String source, String destination, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String availableSeats, String economicSeats, String secondClassSeats, String firstClassSeats, String economicSeatsCapacity, String secondClassSeatsCapacity, String firstClassSeatsCapacity, String baseFare) {
        Flight flight = new Flight(number, source, destination,
                LocalDate.parse(departureDate), LocalTime.parse(departureTime),
                LocalDate.parse(arrivalDate), LocalTime.parse(arrivalTime),
                Integer.parseInt(availableSeats), Integer.parseInt(economicSeats),
                Integer.parseInt(firstClassSeats), Integer.parseInt(secondClassSeats),
                Integer.parseInt(economicSeatsCapacity), Integer.parseInt(firstClassSeatsCapacity),
                Integer.parseInt(secondClassSeatsCapacity),
                Double.parseDouble(baseFare));
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" + number + ".txt"));
            String flightLine = number + "," + source + "," + destination + "," + departureDate + "," + departureTime + "," + arrivalDate + "," + arrivalTime + "," + availableSeats + "," + economicSeats + "," + secondClassSeats + "," + firstClassSeats + "," + economicSeatsCapacity + "," + secondClassSeatsCapacity + "," + firstClassSeatsCapacity + "," + baseFare;
            bufferedWriter.write(flightLine);
            bufferedWriter.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

        return flight;
    }

    // Update
    @DeleteMapping("/flights/{number}")
    public void delete(@PathVariable long number) {
        deletedFlightIds.add(number);
        File file = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" + number + ".txt");
        file.delete();

    }
}
