package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.FilterClass;

import java.io.*;

public class BookTicketService {
    public static void bookLogic(int i, String noOfPass, Long number, String flightClass) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.multiFileReader()[i]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",", -1);
                if (number.equals(Long.parseLong(strings[0]))) {
                    line = line.replace(strings[7], "" + (Integer.parseInt(strings[7]) - Integer.parseInt(noOfPass)));
                    line = FilterClass.filterFlightClass(flightClass, strings, line, noOfPass);
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.multiFileReader()[i]));
                bufferedWriter.write(line);
                bufferedWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bookTicket(String noOfPass, Long number, String flightClass) {
        if (DataParser.multiFileReader() != null) {
            isContainFile(noOfPass, number, flightClass);
        }

    }

    public static void isContainFile(String noOfPass, Long number, String flightClass) {
        for (int i = 1; i < DataParser.multiFileReader().length; i++) {
            if (DataParser.multiFileReader()[i].isFile()) {
                bookLogic(i, noOfPass, number, flightClass);
            }
        }
    }

}
