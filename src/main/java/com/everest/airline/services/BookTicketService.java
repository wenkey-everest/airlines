package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;
import java.io.*;
import java.util.List;
public class BookTicketService {

public static void bookLogic(List<Flight> flightList, int i){
    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.readFile()[i]));
        String line;
        for (Flight flight : flightList) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",", -1);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.readFile()[i]));
                bufferedWriter.write(bookCondition(strings,line,flight));
                bufferedWriter.close();
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static String bookCondition(String[] strings, String line, Flight flight){
    if (strings[7].equals(Integer.toString(flight.getAvailableSeats())) && strings[1].equalsIgnoreCase(flight.getSource()) && strings[2].equalsIgnoreCase(flight.getDestination()))
        return line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));

    return "no flights are found";
}
public static void fileList(List<Flight> flightList){
        if (DataParser.readFile() != null) {
            isContainFile(flightList);
        }
    }

    public static void isContainFile(List<Flight> flightList){
        for (int i = 1; i < DataParser.readFile().length; i++) {
            if (DataParser.readFile()[i].isFile()) {
                bookLogic(flightList, i);
            }
        }
    }
}
