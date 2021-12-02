package com.everest.airline;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class Data {
    static List<Flight> flights = List.of(
            new Flight(1001, "Hyderabad", "Bangalore"),
            new Flight(1002, "Bangalore", "Hyderabad"),
            new Flight(1003, "Goa", "Bangalore"),
            new Flight(1004, "Bangalore", "Goa"),
            new Flight(1005, "Bangalore", "Hyderabad"),
            new Flight(1006, "Hyderabad", "Bangalore"));
}


