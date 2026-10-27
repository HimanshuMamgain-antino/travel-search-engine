package com.himanshu.travelSearchEngine.service.supplier;

import java.util.List;

import com.himanshu.travelSearchEngine.dto.Flight;
import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;

public interface FlightSupplier {

    SupplierCode getCode();

    List<Flight> search(FlightSearchRequest request);
}
