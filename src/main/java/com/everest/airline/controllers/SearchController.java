package com.everest.airline.controllers;

import com.everest.airline.model.Flight;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;


@Controller
public class SearchController {
    @Autowired
    public SearchService searchService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, Model model,String departureDate ) throws Exception {
            List<Flight> testList = searchService.searchByFlight(from,to,departureDate);
                    model.addAttribute("flights", testList);
        return "search";
    }
}
