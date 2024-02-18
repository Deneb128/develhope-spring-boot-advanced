package com.example.demowebapp;

import com.example.demowebapp.entities.Flight;
import com.example.demowebapp.entities.FlightStatus;
import com.example.demowebapp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoWebappApplication {

	@Autowired
	FlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoWebappApplication.class, args);
	}
}
