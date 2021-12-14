package com.everest.airline.model;

public class FilterClass {
    public static String filterFlightClass(String flightClass, String[] strings, String line, String noOfPass) {
        switch (flightClass) {
            case "economic":
                line = line.replace(strings[8], "" + (Integer.parseInt(strings[8]) - Integer.parseInt(noOfPass)));
                break;
            case "firstClass":
                line = line.replace(strings[9], "" + (Integer.parseInt(strings[9]) - Integer.parseInt(noOfPass)));
                break;
            case "secondClass":
                line = line.replace(strings[10], "" + (Integer.parseInt(strings[10]) - Integer.parseInt(noOfPass)));
                break;
        }
        return line;
    }
}
