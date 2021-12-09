package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;

import java.io.*;
import java.util.List;

public class BookTicketService {
    public static void bookTicket(List<Flight> flightList){
        for (Flight flight : flightList) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/tempFile.txt"))) {
                String line;
                BufferedReader br = DataParser.test();
                while ((line = br.readLine()) != null) {
                    if (line.contains(Integer.toString(flight.getAvailableSeats()))) {
                        line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
                    }
                    bw.write(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            File flightData = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt");
            flightData.delete();

            File newFile = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/tempFile.txt");
            newFile.renameTo(flightData);
        }
    }
}
