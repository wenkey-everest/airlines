package com.everest.airline;
import com.everest.airline.database.DataParser;
import com.everest.airline.exceptions.FileNotFoundException;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class FileDivider {
    private String[] strings;
    public void testFileDivider(){
       try{
           List<File> fileList = Arrays.stream(DataParser.multiFileReader())
                   .filter(file -> file.getName().endsWith(".txt"))
                   .collect(Collectors.toList());
           List<String> linesList =  DataParser.singleFileReader().lines().collect(Collectors.toList());
           for(String line : linesList)
           {
               String[] strings=line.split(",");
               for (File file : fileList) {
                   if(file.getName().contains(strings[0])) {
                       FileWriter fw = new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/" +strings[0]+".txt");
                       fw.write(line);
                       fw.close();
                   }
               }
           }
           DataParser.singleFileReader().close();
       }catch (IOException e) {
         throw new FileNotFoundException(e);
       }
    }
}
