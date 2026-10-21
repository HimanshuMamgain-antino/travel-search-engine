package com.himanshu.travelSearchEngine.dto;

import lombok.Getter;

@Getter
public class FlightSearchResponse {
    private final String searchId;
    private final String status;
    private final FlightSearchResult result;

    public FlightSearchResponse(
            String searchId,
            String status,
            FlightSearchResult result
    ) {
        this.searchId = searchId;
        this.status = status;
        this.result = result;
    }
}
