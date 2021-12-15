package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.FilterClass;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class BookTicketService {

    @Autowired
    public FilterClass filterClass;

    public void bookLogic(int i, String noOfPass, Long number, String flightClass, List<Flight> flightList) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.multiFileReader()[i]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",", -1);
                if (number.equals(Long.parseLong(strings[0]))) {
                    line = filterClass.filterFlightClass(flightClass, strings, line, noOfPass, flightList,number);
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.multiFileReader()[i]));
                bufferedWriter.write(line);
                bufferedWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookTicket(String noOfPass, Long number, String flightClass, List<Flight> flightList) {
        if (DataParser.multiFileReader() != null) {
            isContainFile(noOfPass, number, flightClass, flightList);
        }

    }

    public void isContainFile(String noOfPass, Long number, String flightClass, List<Flight> flightList) {
        for (int i = 1; i < DataParser.multiFileReader().length; i++) {
            if (DataParser.multiFileReader()[i].isFile()) {
                bookLogic(i, noOfPass, number, flightClass, flightList);
            }
        }
    }

}
