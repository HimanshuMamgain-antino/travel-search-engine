package com.himanshu.travelSearchEngine.dto;

import lombok.Getter;

@Getter
public class FlightSearchResult {
    private final String tripType;

    public FlightSearchResult(String tripType) {
        this.tripType = tripType;
    }
}
