package com.himanshu.travelSearchEngine.service;

import com.himanshu.travelSearchEngine.dto.Flight;
import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.dto.FlightSearchResponse;
import com.himanshu.travelSearchEngine.service.supplier.FlightSupplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchService {
    private final List<FlightSupplier> suppliers;

    public FlightSearchService(List<FlightSupplier> suppliers) {
        this.suppliers = suppliers;
    }

    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        List<Flight> flights = new ArrayList<>();

        for (FlightSupplier supplier : suppliers) {
            flights.addAll(supplier.search(request));
        }

        return new FlightSearchResponse(flights);
    }
}
