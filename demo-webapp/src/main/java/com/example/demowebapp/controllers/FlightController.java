package com.example.demowebapp.controllers;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import com.example.demowebapp.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping(path = "/")
    public void populateDatabase(){
            flightService.populateDatabase();
        }
    @GetMapping(path = "/")
    public List<Flight> getFlightList(){
        return flightService.getFlightList();
    }
}
