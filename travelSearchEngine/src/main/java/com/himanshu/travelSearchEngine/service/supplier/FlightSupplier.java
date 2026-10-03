package com.himanshu.travelSearchEngine.service.supplier;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.dto.FlightSearchResponse;

import java.util.List;

public interface FlightSupplier {

    SupplierCode getCode();

    List<FlightSearchResponse> search(FlightSearchRequest request);
}
