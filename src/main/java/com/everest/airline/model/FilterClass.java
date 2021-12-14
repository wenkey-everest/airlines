package com.everest.airline.model;

import java.util.List;

public class FilterClass {
    public static String filterFlightClass(String flightClass, String[] strings, String line, String noOfPass, List<Flight> flightList, Long number) {
        int passengers = Integer.parseInt(noOfPass);
        for(Flight flight:flightList) {
            if (number.equals(flight.getNumber())) {
                switch (flightClass) {
                    case "economic":
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - Integer.parseInt(noOfPass)) + "," + (Integer.parseInt(strings[8]) - Integer.parseInt(noOfPass)) + "," + strings[9] + "," + strings[10] + "," + Double.parseDouble(strings[11]);
                        flight.setTotalFare(flight.getEconomicFare() * passengers);
                        break;
                    case "firstClass":
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - Integer.parseInt(noOfPass)) + "," + strings[8] + "," + (Integer.parseInt(strings[9]) - Integer.parseInt(noOfPass)) + "," + strings[10] + "," + Double.parseDouble(strings[11]);
                        flight.setTotalFare(flight.getFirstClassFare() * passengers);
                        break;
                    case "secondClass":
                        line = strings[0] + "," + strings[1] + "," + strings[2] + "," + strings[3] + "," + strings[4] + "," + strings[5] + "," + strings[6] + "," + (Integer.parseInt(strings[7]) - Integer.parseInt(noOfPass)) + "," + strings[8] + "," + strings[9] + "," + (Integer.parseInt(strings[10]) - Integer.parseInt(noOfPass)) + "," + Double.parseDouble(strings[11]);
                        flight.setTotalFare(flight.getSecondClassFare() * passengers);
                        break;
                }
            }
        }
        return line;
    }

}
