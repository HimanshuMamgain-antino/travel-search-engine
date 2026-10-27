package com.himanshu.travelSearchEngine.dto;

import java.util.List;

public record FlightSearchResponse(
        List<Flight> flights) {
}
