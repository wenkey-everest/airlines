package com.everest.airline.services;
import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;

import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchService {
    private List<Flight> flightList;
    public List<Flight> test(String from, String to, String departureDate) {
        File dir = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights");
        File[] directoryListing = dir.listFiles();
        flightList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        if (directoryListing != null) {
            for (int i = 1; i < directoryListing.length; i++) {
                if (directoryListing[i].isFile()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(directoryListing[i]));
                        String[] strings = bufferedReader.readLine().split(",", -1);
                        if (strings[1].equalsIgnoreCase(from) && strings[2].equalsIgnoreCase(to)) {
                            flightList.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            }
            return flightList.parallelStream()
                    .filter(s -> (s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                    .collect(Collectors.toList());
        }
    }
