package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @GetMapping
    public String displayAllEvents(Model model) {  // Handler method for GET requests
        List<String> events = new ArrayList<>();  // Empty list
        events.add("Stadium of Fire");
        events.add("Super Bowl");
        events.add("Chalk the Block");
        model.addAttribute("events", events);   // Add list to model
        return "events/index";   // Return template name
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

}
