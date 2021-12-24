package com.everest.airline.database;

import com.everest.airline.model.Flight;
import com.everest.airline.model.SortingList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReader {
    public List<Flight> getFlightsList() {
        List<Flight> flightList = new ArrayList<>();
            for (File file : DataParser.multiFileReader()) {
                if (file.getName().endsWith(".txt")) {
                    try {
                        String[] strings = new BufferedReader(new FileReader(file)).readLine().split(",", -1);
                        Flight flight = new Flight(Long.parseLong(strings[0]), strings[1], strings[2],
                                LocalDate.parse(strings[3]), LocalTime.parse(strings[4]),
                                LocalDate.parse(strings[5]), LocalTime.parse(strings[6]),
                                Integer.parseInt(strings[7]), Integer.parseInt(strings[8]),
                                Integer.parseInt(strings[9]), Integer.parseInt(strings[10]),
                                Integer.parseInt(strings[11]), Integer.parseInt(strings[12]),
                                Integer.parseInt(strings[13]),
                                Double.parseDouble(strings[14]));
                        flightList.add(flight);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
  flightList.sort(new SortingList());
        return flightList;
    }
}
