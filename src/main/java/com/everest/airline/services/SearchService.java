package com.everest.airline.services;
import com.everest.airline.model.Flight;
import org.apache.coyote.OutputBuffer;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchService {
    private static List<Flight> flightList;
    public List<Flight> searchByFlight(String from, String to, String departureDate){
        try (FileInputStream fileInputStream = new FileInputStream("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt")) {
            List<String> result = new BufferedReader(new InputStreamReader(fileInputStream))
                    .lines().collect(Collectors.toList());
            List<String[]> test2 = result.stream().map(x -> x.split(",", -1))
                    .collect(Collectors.toList());
            flightList = new ArrayList<>();
            for (String[] strings : test2) {
                    if ((from.equalsIgnoreCase(strings[1])) && (to.equalsIgnoreCase(strings[2])))
                        flightList.add(new Flight(Long.parseLong(strings[0]), strings[1], strings[2], LocalDate.parse(strings[3]), LocalTime.parse(strings[4]), LocalDate.parse(strings[5]), LocalTime.parse(strings[6]), Integer.parseInt(strings[7])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList.parallelStream()
                .filter(s->(s.getSource().equalsIgnoreCase(from) && s.getDestination().equalsIgnoreCase(to) && s.getDepartureDate().equals(LocalDate.parse(departureDate))))
                .collect(Collectors.toList());
    }
    public void bookTicket(List<Flight> flightList){
        for (Flight flight : flightList) {
            try (BufferedReader br = new BufferedReader(new FileReader("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/flightData.txt"));
                 BufferedWriter bw = new BufferedWriter(new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/database/tempFile.txt"))) {
                String line;
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
