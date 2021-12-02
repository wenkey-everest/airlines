package com.everest.airline;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class Data {
    static List<Flight> flights = List.of(
            new Flight(1001, "Hyderabad", "Bangalore", LocalDate.of(2021,12,2), LocalDate.of(2021,12,4)),
            new Flight(1002, "Bangalore", "Hyderabad",LocalDate.of(2021,12,3), LocalDate.of(2021,12,4)),
            new Flight(1003, "Goa", "Bangalore",LocalDate.of(2021,12,4), LocalDate.of(2021,12,5)),
            new Flight(1004, "Bangalore", "Goa",LocalDate.of(2021,12,5), LocalDate.of(2021,12,6)),
            new Flight(1005, "Bangalore", "Hyderabad",LocalDate.of(2021,12,2), LocalDate.of(2021,12,4)),
            new Flight(1006, "Hyderabad", "Bangalore",LocalDate.of(2021,12,6), LocalDate.of(2021,12,10)));
}


