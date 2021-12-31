package com.everest.airline.model;

import java.util.Comparator;

public class SortingList implements Comparator<Flight> {

    public int compare(Flight f1, Flight f2) {
        return Long.compare(f1.getNumber(), f2.getNumber());
    }
}




