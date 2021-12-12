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
   private List<Flight> flightList = new ArrayList<>();
    private BufferedReader bufferedReader = null;
    public List<Flight> searchByFlight(String from, String to, String departureDate) {
        if (DataParser.readFile() != null) {
            searchLogic(from, to, departureDate);
            }
            return flightList.parallelStream()
                    .filter(s -> (s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                    .collect(Collectors.toList());
        }
        public void searchLogic(String from, String to, String departureDate){
            for (int i = 1; i < DataParser.readFile().length; i++) {
                if (DataParser.readFile()[i].isFile()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(DataParser.readFile()[i]));
                        String[] strings = bufferedReader.readLine().split(",", -1);
                        if (strings[1].equalsIgnoreCase(from) && strings[2].equalsIgnoreCase(to) && LocalDate.parse(departureDate).equals(LocalDate.parse(strings[3]))) {
                            flightList.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
