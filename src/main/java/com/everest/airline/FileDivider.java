package com.everest.airline;
import com.everest.airline.database.DataParser;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class FileDivider {
    private final String[] filenames={"1001","1002","1003","1004","1005","1006"};
    private FileWriter fw=null;
    public void testFileDivider(){
       try{
           List<String> linesList =  DataParser.test().lines().collect(Collectors.toList());
           for(String line:linesList)
           {
               for (String filename : filenames) {
                   if(line.contains(filename)) {
                       fw= new FileWriter("/Volumes/everest/airlines_tdd/airlines/src/main/java/com/everest/airline/Flights/"+filename+".txt");
                       fw.write(line);
                       fw.close();
                   }
               }
           }
           DataParser.test().close();

       }catch (IOException e) {
           e.printStackTrace();
       }
    }
}
