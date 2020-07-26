package com.github.codegeek.dronetest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.codegeek.dronetest.model.Greeting;
import com.github.codegeek.dronetest.services.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {
    private static final String URL = "/greeting";

    @MockBean
    private GreetingService greetingService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGreeting() throws Exception {
        when(greetingService.greeting(anyString())).thenReturn(Greeting.builder().id(1).content("Hello, World!").build());
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        int status = result.getResponse().getStatus();
        assertThat(status).isEqualTo(HttpStatus.OK.value());
        String response = result.getResponse().getContentAsString();
        assertThat(response).isNotEmpty();
        Greeting greeting = objectMapper.readValue(response, Greeting.class);
        assertThat(greeting).isNotNull();
        assertThat(greeting.getContent()).isEqualTo("Hello, World!");
    }
}
