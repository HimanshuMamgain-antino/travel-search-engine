package com.himanshu.travelSearchEngine.service;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.dto.FlightSearchResponse;
import com.himanshu.travelSearchEngine.service.supplier.FlightSupplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightSearchService {
    private final List<FlightSupplier> suppliers;

    public FlightSearchService(List<FlightSupplier> suppliers) {
        this.suppliers = suppliers;
    }

    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        for (FlightSupplier supplier: suppliers) {
            System.out.println("Search supplier: " + supplier.getCode());

            supplier.search(request);
        }

        return null;
    }
}
