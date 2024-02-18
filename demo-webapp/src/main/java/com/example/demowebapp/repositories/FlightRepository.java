package com.example.demowebapp.repositories;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM flights", nativeQuery = true)
    public Page<Flight> getPageWithLimit(PageRequest pageRequest);

    @Query(value = "SELECT * FROM flights", nativeQuery = true)
    public Page<Flight> getPageAscendingByAirport(PageRequest pageRequest);

    @Query(value = "SELECT * FROM flights LIMIT ?1", nativeQuery = true)
    List<Flight> findAllWithLimit(Integer limit);

    List<Flight> findByFlightStatus(FlightStatus flightStatus);

    @Query(value = "SELECT * FROM flights WHERE flight_status = ?1 OR flight_status = ?2", nativeQuery = true)
    List<Flight> findByTwoStatuses(FlightStatus flightStatus1, FlightStatus flightStatus2);

}
