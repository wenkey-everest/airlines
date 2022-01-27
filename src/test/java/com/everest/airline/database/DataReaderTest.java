package com.everest.airline.database;

import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Autowired
    private DataReader dataReader;
    @Test
    public void isListContainFlightTest() {
        for(Flight flight :dataReader.getAllFlights()){
            assertSame(flight.getClass(), Flight.class);
        }
    }
}