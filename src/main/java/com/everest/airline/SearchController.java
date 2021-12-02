package com.everest.airline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
public class SearchController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, Model model,String departureDate ) {
        Search search = new Search(from,to,departureDate);
        model.addAttribute("flights", search.SearchByPlace());
        return "search";
    }
}
