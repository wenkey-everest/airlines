package com.everest.airline.controllers;

import com.everest.airline.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SearchController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, Model model,String departureDate ) {
        SearchService searchService = new SearchService(from,to,departureDate);
        model.addAttribute("flights", searchService.searchByPlace());
        return "search";
    }
}
