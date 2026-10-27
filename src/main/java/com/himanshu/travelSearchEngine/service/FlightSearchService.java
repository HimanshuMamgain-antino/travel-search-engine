package com.himanshu.travelSearchEngine.service;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.service.supplier.FlightSupplier;
import com.himanshu.travelSearchEngine.service.supplier.SupplierCode;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightSearchService {
    private final List<FlightSupplier> suppliers;

    public FlightSearchService(List<FlightSupplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Map<SupplierCode, JsonNode> searchFlights(FlightSearchRequest request) {
        Map<SupplierCode, JsonNode> responses = new LinkedHashMap<>();

        for (FlightSupplier supplier: suppliers) {
            System.out.println("Search supplier: " + supplier.getCode());

            responses.put(supplier.getCode(), supplier.search(request));
        }

        return responses;
    }
}
