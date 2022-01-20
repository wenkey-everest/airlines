package com.everest.airline.services;

import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchServiceTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void searchServiceTest(){
        List<Flight> searchFlightList = searchService.searchByFlight("Bangalore", "Hyderabad","04-01-2022","economy","20");
        System.out.println(searchFlightList);
        assertTrue(3!=2);
     }


}