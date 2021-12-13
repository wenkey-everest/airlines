package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class BookTicketService {
private static List<Flight> test;
    public static void bookLogic(List<Flight> flightList, int i, String noOfPass) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.multiFileReader()[i]));
            String line;
            for (Flight flight : flightList) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.split(",", -1);
                    if (strings[7].equals(Integer.toString(flight.getAvailableSeats())) && strings[1].equalsIgnoreCase(flight.getSource()) && strings[2].equalsIgnoreCase(flight.getDestination())) {
                        line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - Integer.parseInt(noOfPass)));
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.multiFileReader()[i]));
                    bufferedWriter.write(line);
                    bufferedWriter.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void bookTicket(List<Flight> flightList, String noOfPass) {
        if (DataParser.multiFileReader() != null) {
            isContainFile(flightList, noOfPass);
        }

    }

    public static void isContainFile(List<Flight> flightList, String noOfPass) {
        for (int i = 1; i < DataParser.multiFileReader().length; i++) {
            if (DataParser.multiFileReader()[i].isFile()) {
                bookLogic(flightList, i, noOfPass);
            }
        }
    }
}
