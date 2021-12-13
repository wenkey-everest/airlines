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
    public static void bookLogic(int i, String noOfPass, Long number) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.multiFileReader()[i]));
            String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.split(",", -1);
                    if (number.equals(Long.parseLong(strings[0]))) {
                        line = line.replace(strings[7], "" + (Integer.parseInt(strings[7]) - Integer.parseInt(noOfPass)));
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.multiFileReader()[i]));
                    bufferedWriter.write(line);
                    bufferedWriter.close();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bookTicket( String noOfPass, Long number) {
        if (DataParser.multiFileReader() != null) {
            isContainFile( noOfPass,number);
        }

    }

    public static void isContainFile( String noOfPass, Long number) {
        for (int i = 1; i < DataParser.multiFileReader().length; i++) {
            if (DataParser.multiFileReader()[i].isFile()) {
                bookLogic( i, noOfPass, number);
            }
        }
    }

}
