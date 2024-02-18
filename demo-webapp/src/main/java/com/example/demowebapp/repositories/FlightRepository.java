package com.example.demowebapp.repositories;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flights LIMIT 50",
    nativeQuery = true)
    List<Flight> get50Flights();

}
