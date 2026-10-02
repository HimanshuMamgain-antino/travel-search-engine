package com.himanshu.travelSearchEngine.dto;

import lombok.Getter;

@Getter
public class CreateTravelRequest {
    private final String source;
    private final String destination;

    public CreateTravelRequest(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
}
