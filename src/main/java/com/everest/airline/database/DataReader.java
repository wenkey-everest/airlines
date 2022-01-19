package com.everest.airline.database;

import com.everest.airline.exceptions.FileNotFoundException;
import com.everest.airline.flightClassViews.EconomyClass;
import com.everest.airline.flightClassViews.FirstClass;
import com.everest.airline.flightClassViews.SecondClass;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataReader {
    public List<Flight> getFlightsList() {
       return Arrays.stream(DataParser.multiFileReader())
                .filter(file -> file.getName().endsWith(".txt"))
                .map(file->{
                    try {
                        String[] strings = new BufferedReader(new FileReader(file)).readLine().split(",");
                        EconomyClass economyClass = new EconomyClass(Integer.parseInt(strings[8]), Integer.parseInt(strings[11]));
                        FirstClass firstClass = new FirstClass(Integer.parseInt(strings[9]), Integer.parseInt(strings[12]));
                        SecondClass secondClass = new SecondClass(Integer.parseInt(strings[10]), Integer.parseInt(strings[13]));
                        return new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]),  LocalDate.parse(strings[5]), LocalTime.parse(strings[6]),  Integer.parseInt(strings[7]), economyClass, secondClass, firstClass, Double.parseDouble(strings[14]));
                    } catch (IOException e) {
                        throw new FileNotFoundException(e);
                    }
                }).collect(Collectors.toList());
    }
}