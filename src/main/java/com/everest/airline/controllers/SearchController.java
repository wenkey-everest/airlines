package com.everest.airline.controllers;

import com.everest.airline.FileDivider;
import com.everest.airline.model.Flight;
import com.everest.airline.services.BookTicketService;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    public SearchService searchService;

    private String from;
    private String to;
    private String departureDate;

    @Autowired
    public FileDivider fileDivider;

    @Autowired
    public BookTicketService bookTicketService;

    @RequestMapping(value = "/")
    public String home() {
//       fileDivider.testFileDivider();
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, Model model, String departureDate) {
        if(from!=null) {
            this.from = from;
            this.to = to;
            this.departureDate = departureDate;
        }
       List<Flight> flightList = searchService.searchByFlight(this.from, this.to, this.departureDate);
        if (flightList.size() > 0) {
            model.addAttribute("flights", flightList);
            return "search";
        } else {
            try {
                throw new Exception("No flights with data from " + from + " to " + to + " on " + departureDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "noFlight";
        }
    }

    @RequestMapping(value = "/{number}")
    public String book(@PathVariable("number") Long number, String flightClass, String noOfPass, Model model) {
        if (noOfPass.isEmpty()) {
            try {
                throw new Exception("Please enter number of passengers");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "noFlight";
        } else {
           List<Flight> flightList= bookTicketService.bookTicket(noOfPass, number, flightClass);
            model.addAttribute("flights", flightList);
            return "book";
        }
    }

}