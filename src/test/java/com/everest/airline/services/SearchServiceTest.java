package com.everest.airline.services;

import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    public void searchByDestinationTest(){
            SearchService searchService = new SearchService("Hyderabad","Bangalore", "2021-12-02");
            assertTrue(searchService.searchByFlight().get(0).getDestination().equalsIgnoreCase("Bangalore"));
    }
    @Test
    public void searchByDateTest(){
        SearchService searchService = new SearchService("Hyderabad","Bangalore", "2021-12-02");
            assertEquals(searchService.searchByFlight().get(0).getDepartureDate(), LocalDate.parse("2021-12-02"));
    }

}