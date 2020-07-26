package com.github.codegeek.dronetest.services;

import com.github.codegeek.dronetest.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting greeting(String name) {
        return Greeting.builder()
                .id(counter.incrementAndGet())
                .content(String.format(template, name))
                .build();
    }
}
