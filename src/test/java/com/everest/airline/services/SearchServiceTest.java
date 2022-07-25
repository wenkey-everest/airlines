package com.everest.airline.services;

import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    public void searchServiceTest(){
        List<Flight> searchFlightList = new SearchService().searchByFlight("bangalore", "Tirupathi","2022-01-06","economic","20");
        assertFalse(searchFlightList.isEmpty());
     }
}