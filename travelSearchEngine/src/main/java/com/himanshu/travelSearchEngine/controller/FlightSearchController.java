package com.himanshu.travelSearchEngine.controller;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.dto.FlightSearchResponse;
import com.himanshu.travelSearchEngine.service.FlightSearchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flight-search")
public class FlightSearchController {
    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @PostMapping
    public FlightSearchResponse searchFlight(@Valid @RequestBody FlightSearchRequest request) {
        return flightSearchService.searchFlights(request);
    }
}
