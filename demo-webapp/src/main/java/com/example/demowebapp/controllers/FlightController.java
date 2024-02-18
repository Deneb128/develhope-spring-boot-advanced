package com.example.demowebapp.controllers;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import com.example.demowebapp.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping(path = "/all")
    public List<Flight> getFlightList() {
        return flightService.getFlightList();
    }

    @PostMapping(path = "/addflights")
    public ResponseEntity<?> populateDatabase(@RequestParam(defaultValue = "100") Integer limit) {
        return flightService.populateDatabase(limit);
    }

    @GetMapping(path = "/getpage")
    public Page<Flight> getPageAscendingByAirport(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "100") Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Flight> flights = flightService.getPageAscendingByAirport(pageable);
        return flights;
    }

    @GetMapping(path = "/getontime")
    public List<Flight> getOnTimeList() {
        return flightService.getOnTimeList();
    }

    @GetMapping(path = "/getbytwostatuses")
    public ResponseEntity<?> getByTwoStatuses(@RequestParam String status1, @RequestParam String status2) {
        return flightService.getByTwoStatuses(status1.toUpperCase(), status2.toUpperCase());
    }
}
