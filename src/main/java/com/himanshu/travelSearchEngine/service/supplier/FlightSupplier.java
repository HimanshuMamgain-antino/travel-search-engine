package com.himanshu.travelSearchEngine.service.supplier;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import tools.jackson.databind.JsonNode;

public interface FlightSupplier {

    SupplierCode getCode();

    JsonNode search(FlightSearchRequest request);
}
