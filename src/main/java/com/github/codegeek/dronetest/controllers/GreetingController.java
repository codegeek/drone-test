package com.github.codegeek.dronetest.controllers;

import com.github.codegeek.dronetest.model.Greeting;
import com.github.codegeek.dronetest.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
        return greetingService.greeting(name);
    }
}
