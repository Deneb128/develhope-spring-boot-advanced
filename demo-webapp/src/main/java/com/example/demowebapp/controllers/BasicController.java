package com.example.demowebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/")
public class BasicController {

    @Autowired
    private Environment environment;
    @GetMapping
    public String greeting(){
        return "devName: " + environment.getProperty("devName") + "\nauthCode: " + environment.getProperty("authCode");
    }
}
