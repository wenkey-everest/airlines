package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.FilterClass;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookTicketService {

    @Autowired
    public FilterClass filterClass;

    private List<Flight> flightList;


    public void bookLogic(int i, String noOfPass, Long number, String flightClass) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DataParser.multiFileReader()[i]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",", -1);
                if (number.equals(Long.parseLong(strings[0]))) {
                    Flight flight = new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7]),Integer.parseInt(strings[8]),Integer.parseInt(strings[9]),Integer.parseInt(strings[10]),Integer.parseInt(strings[11]),Integer.parseInt(strings[12]),
                            Integer.parseInt(strings[13]),Double.parseDouble(strings[14]));
                    flightList.add(flight);
                     filterClass.filterFlightClass(flightClass, noOfPass, flightList, number,flight.getEconomicSeats(),flight.getFirstClassSeats(), flight.getSecondClassSeats());
                     line=filterClass.getLine();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DataParser.multiFileReader()[i]));
                bufferedWriter.write(line);
                bufferedWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> bookTicket(String noOfPass, Long number, String flightClass) {
        if (DataParser.multiFileReader() != null) {
            flightList=new ArrayList<>();
            isContainFile(noOfPass, number, flightClass);
        }
        return flightList;
    }

    public void isContainFile(String noOfPass, Long number, String flightClass) {
        for (int i = 1; i < DataParser.multiFileReader().length; i++) {
            if (DataParser.multiFileReader()[i].isFile()) {
                bookLogic(i, noOfPass, number, flightClass);
            }
        }
    }

}
