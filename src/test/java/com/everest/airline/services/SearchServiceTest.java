package com.everest.airline.services;

import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    public void searchDestinationTest(){
            SearchService searchService = new SearchService("Hyderabad","Bangalore", "2021-12-02");
            for(int i=0;i<searchService.searchByPlace().size();i++)
            assertTrue(searchService.searchByPlace().get(i).getDestination().equalsIgnoreCase("Bangalore"));
    }
    @Test
    public void searchDateTest(){
        SearchService searchService = new SearchService("Hyderabad","Bangalore", "2021-12-02");
        for(int i=0;i<searchService.searchByPlace().size();i++)
            assertEquals(searchService.searchByPlace().get(i).getDepartureDate(), LocalDate.parse("2021-12-02"));
    }

}