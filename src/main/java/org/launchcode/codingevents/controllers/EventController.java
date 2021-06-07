package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();   // List accessible for multiple methods

    @GetMapping
    public String displayAllEvents(Model model) {  // Handler method for GET requests
//        List<String> events = new ArrayList<>();  // Empty list
//        events.add("Stadium of Fire");
//        events.add("Super Bowl");
//        events.add("Chalk the Block");
        model.addAttribute("events", events);   // Add list to model
        return "events/index";   // Return template name
    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {   // Handler method for POST requests
        events.add(eventName);
        return "redirect:";   // redirect: says redirect them to the root path for this specific controller - in this case it will redirect to the displayAllEvents handler and the user will see a list of events
    }

}
