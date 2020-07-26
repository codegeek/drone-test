package com.github.codegeek.dronetest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Greeting.GreetingBuilder.class)
public class Greeting {
    long id;
    String content;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GreetingBuilder {}
}
