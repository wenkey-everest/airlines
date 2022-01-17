package com.everest.airline.database;

import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    @Test
    public void isListContainFlightTest() {
        for(Flight flight : new DataReader().getFlightsList()){
            assertSame(flight.getClass(), Flight.class);
        }
    }
}