package com.himanshu.travelSearchEngine.dto;

import lombok.Getter;

@Getter
public class TravelResponse {
    private final Long id;
    private final String source;
    private final String destination;

    public TravelResponse(Long id, String source, String destination) {
        this.id = id;
        this.source = source;
        this.destination = destination;
    }
}
