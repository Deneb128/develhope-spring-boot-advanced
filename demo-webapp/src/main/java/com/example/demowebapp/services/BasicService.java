package com.example.demowebapp.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
@Slf4j
public class BasicService {

    public String getPowerOfTwo(String customIntFirst, String customIntSecond) {
        Integer a = Integer.valueOf(customIntFirst);
        Integer b = Integer.valueOf(customIntSecond);
        log.info("starting calculating {} to the power of {}", a, b); //fmt I love you
        Integer result = Double.valueOf(Math.pow(a, b)).intValue();
        log.info("finished calculating {} to the power of {}", a, b);
        log.info("Result: {}", result);
        return String.valueOf(result);
    }
}
