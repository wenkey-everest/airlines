package com.everest.airline;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class Data {
    static List<Flight> flights = List.of(
            new Flight(1001, "Hyderabad", "Bangalore", LocalDate.of(2021,12,2), LocalTime.of(12,30), LocalDate.of(2021,12,4), LocalTime.of(17,30)),
            new Flight(1002, "Bangalore", "Hyderabad",LocalDate.of(2021,12,3),LocalTime.of(1,30), LocalDate.of(2021,12,4), LocalTime.of(5,30)),
            new Flight(1003, "Goa", "Bangalore",LocalDate.of(2021,12,4),LocalTime.of(4,30), LocalDate.of(2021,12,5),LocalTime.of(13,25)),
            new Flight(1004, "Bangalore", "Goa",LocalDate.of(2021,12,5),LocalTime.of(5,10), LocalDate.of(2021,12,6),LocalTime.of(8,50)),
            new Flight(1005, "Bangalore", "Hyderabad",LocalDate.of(2021,12,2),LocalTime.of(10,30), LocalDate.of(2021,12,4),LocalTime.of(14,15)),
            new Flight(1006, "Hyderabad", "Bangalore",LocalDate.of(2021,12,6),LocalTime.of(13,50), LocalDate.of(2021,12,10),LocalTime.of(18,25)));
}


