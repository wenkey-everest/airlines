package com.everest.airline.controllers;

import com.everest.airline.FileDivider;
import com.everest.airline.model.Flight;
import com.everest.airline.services.BookTicketService;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    public SearchService searchService;


    public List<Flight> flightList;

    @Autowired
    public FileDivider fileDivider;

    @RequestMapping(value = "/")
    public String home() {
//       fileDivider.testFileDivider();
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, Model model,String departureDate) {
            flightList = searchService.searchByFlight(from,to,departureDate);
            BookTicketService.fileList(flightList);
            if(flightList.size()>0) {
                model.addAttribute("flights", flightList);
                return "search";
            }else {
                try {
                    throw new Exception("No flights with data from "+from+ " to "+to+" on "+departureDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "noFlight";
            }
    }

}
