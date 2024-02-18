package com.example.demowebapp.services;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import com.example.demowebapp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public void populateDatabase() {
        List<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 10000; i++) {
            Flight flight = new Flight();
            Random random = new Random();
            //System.out.println(random.ints(97,123).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setDescription(random.ints(97,123).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setFromAirport(random.ints(97,123).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            flight.setToAirport(random.ints(97,123).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            String[] flightStatuses = {"ONTIME", "CANCELLED", "DELAYED"};
            flight.setFlightStatus(FlightStatus.valueOf(flightStatuses[random.nextInt(0, 3)]));
            flightRepository.saveAndFlush(flight);
        }
    }
    public List getFlightList() {
        return flightRepository.findAll();
    }
    public List get50Flights() {
        return flightRepository.get50Flights();
    }
}
