package com.himanshu.travelSearchEngine.controller;

import com.himanshu.travelSearchEngine.dto.CreateTravelRequest;
import com.himanshu.travelSearchEngine.dto.TravelResponse;
import com.himanshu.travelSearchEngine.service.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/travels")
    public List<TravelResponse> getTravels() {
        return travelService.getTravels();
    }

    @GetMapping("/travels/{id}")
    public TravelResponse getTravelById(@PathVariable Long id) {
        return travelService.getTravelById(id);
    }

    @PostMapping("/travels")
    public TravelResponse createTravel(
            @RequestBody CreateTravelRequest request) {
        return travelService.createTravel(request);
    }
}
