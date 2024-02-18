package com.example.demowebapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(length=50, nullable=false)
    private String description = "";

    @Column(length=50, nullable=false)
    private String fromAirport = "";
    @Column(length=50, nullable=false)
    private String toAirport = "";
    @Enumerated
    private FlightStatus flightStatus = FlightStatus.ONTIME;

}
