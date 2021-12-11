package com.everest.airline.services;

import com.everest.airline.model.Flight;
import java.io.*;
import java.util.List;
public class BookTicketService {
//    public static void bookTicket(List<Flight> flightList){
//        for (Flight flight : flightList) {
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/tempFile.txt"))) {
//                String line;
//                BufferedReader br = DataParser.test();
//                while ((line = br.readLine()) != null) {
//                    if (line.contains(Integer.toString(flight.getAvailableSeats()))) {
//                        line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
//                    }
//                    bw.write(line + "\n");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            File flightData = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt");
//            flightData.delete();
//
//            File newFile = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/tempFile.txt");
//            newFile.renameTo(flightData);
//        }
//    }
    public static void bookTicketTest(List<Flight> flightList){
        File dir = new File("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights");
        File[] directoryListing = dir.listFiles();
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        if (directoryListing != null) {
            for (int i = 1; i < directoryListing.length; i++) {
                if (directoryListing[i].isFile())
                    try {
                        bufferedReader = new BufferedReader(new FileReader(directoryListing[i]));
                        String line;

                        for(Flight flight:flightList) {
                            while ((line = bufferedReader.readLine()) != null) {
                                String[] strings = line.split(",", -1);
                                if (line.contains(Integer.toString(flight.getAvailableSeats())) && strings[1].equalsIgnoreCase(flight.getSource()) && strings[2].equalsIgnoreCase(flight.getDestination())) {
                                    line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
                                }
                                bufferedWriter = new BufferedWriter(new FileWriter(directoryListing[i]));
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
