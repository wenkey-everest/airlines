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
    public String search(String from, String to, Model model, String departureDate,String flightClass, String noOfPass) {

        List<Flight> flightList = null;
        try {
            flightList = searchService.searchByFlight(from, to, departureDate,flightClass,noOfPass);
        } catch (Exception e) {
            return "noFlight";
        }
            model.addAttribute("flights", flightList);
            model.addAttribute("flightClass",flightClass);
            model.addAttribute("noOfPass",noOfPass);
            model.addAttribute("totalFare",searchService.getTotalCost());
            return "search";
    }

    @RequestMapping(value = "/{number}/{flightClass}/{noOfPass}")
    public String book(@PathVariable("number") Long number, @PathVariable("flightClass") String flightClass,@PathVariable("noOfPass") String noOfPass, Model model) {
        if (noOfPass.isEmpty()) {
            try {
                throw new Exception("Please enter number of passengers");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "noFlight";
        } else {
                List<Flight> flightList = bookTicketService.bookTicket(noOfPass, number, flightClass);
                model.addAttribute("flights", flightList);
                return "book";
        }
    }

}