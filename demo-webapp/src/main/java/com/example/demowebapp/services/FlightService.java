package com.example.demowebapp.services;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import com.example.demowebapp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public ResponseEntity<?> populateDatabase(int limit) {
        List<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < limit; i++) {
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
        return new ResponseEntity<>(flightRepository.findAll(), HttpStatus.OK);
    }
    public List getFlightList() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsListWithLimit(Integer limit){
        return flightRepository.findAllWithLimit(limit);
    }
    public Page<Flight> getPageWithLimit(Pageable pageable) {
        return flightRepository.getPageWithLimit(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }
    public Page<Flight> getPageAscendingByAirport(Pageable pageable) {
        return flightRepository.getPageAscendingByAirport(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("from_airport")));
    }

    public List<Flight> getOnTimeList() {
        return flightRepository.findByFlightStatus(FlightStatus.ONTIME);
    }

    public ResponseEntity<?> getByTwoStatuses(String status1, String status2) {
        if(FlightStatus.isValidFlightStatus(status1.toUpperCase()) && FlightStatus.isValidFlightStatus(status2.toUpperCase())) {
            List<Flight> flights = flightRepository.findByTwoStatuses(FlightStatus.valueOf(status1), FlightStatus.valueOf(status2));
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
