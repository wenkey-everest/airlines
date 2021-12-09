package com.everest.airline.services;
import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchService {
    private List<Flight> flightList;
    public List<Flight> searchByFlight(String from, String to, String departureDate){
        try  {
            List<String> result = DataParser.test().lines().collect(Collectors.toList());
            List<String[]> test2 = result.stream().map(x -> x.split(",", -1))
                    .collect(Collectors.toList());
            flightList = new ArrayList<>();
            for (String[] strings : test2) {
                    if ((from.equalsIgnoreCase(strings[1])) && (to.equalsIgnoreCase(strings[2])))
                        flightList.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList.parallelStream()
                .filter(s->(s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                .collect(Collectors.toList());
    }

}
