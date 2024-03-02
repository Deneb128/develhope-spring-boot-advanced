package com.example.demowebapp.controllers;

import com.example.demowebapp.services.BasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class BasicController {


    private final BasicService basicService;
    @Value("${customIntFirst}")
    private String customIntFirst;

    @Value("${customIntSecond}")
    private String customIntSecond;

    @GetMapping
    public String getHello() {
        String message = "Hello";
        log.info(message);
        return message;
    }

    @GetMapping("exp")
    public String powerOfTwo() {
        return basicService.getPowerOfTwo(customIntFirst, customIntSecond);
    }

    @GetMapping("/error")
    public void throwError() {
        Exception exception = new Exception("Custom error occurred!");
        log.error("Custom error thrown", exception);
    }
}
