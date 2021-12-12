package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class BookTicketService {
 public static void bookTicketTest(List<Flight> flightList){

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        List<Flight> test=null;
        if (DataParser.testData() != null) {
            test = new ArrayList<>();
            for (int i = 1; i < DataParser.testData().length; i++) {
                if (DataParser.testData()[i].isFile()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(DataParser.testData()[i]));
                        String line;
                        for (Flight flight : flightList) {
                            while ((line = bufferedReader.readLine()) != null) {
                                String[] strings = line.split(",", -1);
                                if (strings[7].equals(Integer.toString(flight.getAvailableSeats())) && strings[1].equalsIgnoreCase(flight.getSource()) && strings[2].equalsIgnoreCase(flight.getDestination())) {
                                    line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
                                    test.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
                                }
                                bufferedWriter = new BufferedWriter(new FileWriter(DataParser.testData()[i]));
                                bufferedWriter.write(line);
                                bufferedWriter.close();
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
