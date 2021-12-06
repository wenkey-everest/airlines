package com.everest.airline.services;
import com.everest.airline.database.Data;
import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchService {

    public List<Flight> searchByFlight(String from, String to, String departureDate){
        return DataParser.getFlightList().parallelStream()
                .filter(s->(s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                .collect(Collectors.toList());
    }

}
