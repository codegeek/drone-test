package com.github.codegeek.dronetest.services;

import com.github.codegeek.dronetest.model.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(GreetingService.class)
public class GreetingServiceTest {
    @Autowired
    private GreetingService service;

    @Test
    void testGreeting() {
        Greeting result  = service.greeting("Test");
        assertThat(result).isNotNull();
        assertThat(result.getContent()).isEqualTo("Hello, Test!");
    }
}
