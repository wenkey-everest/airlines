package com.everest.airline.database;

import com.everest.airline.model.Flight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {
    private static List<Flight> flightList;
    public static List<Flight> getFlightData(){
        try (FileInputStream fileInputStream = new FileInputStream("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt")) {
            List<String> result = new BufferedReader(new InputStreamReader(fileInputStream))
                    .lines().collect(Collectors.toList());
            List<String[]> test2=  result.stream().map(x->x.split(",",-1))
                    .collect(Collectors.toList());
            flightList = new ArrayList<>();
            for (String[] strings : test2) {
                flightList.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
            }
        }catch (FileNotFoundException e){
            throw new Error(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightList;
    }
}
