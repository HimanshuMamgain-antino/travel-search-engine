package com.himanshu.travelSearchEngine.service.supplier.tripjack;

import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.service.supplier.tripjack.dto.TripjackSearchRequest;

import java.util.List;
import java.util.Objects;

public class TripjackRequestMapper {
    public static TripjackSearchRequest map(FlightSearchRequest request) {
        return new TripjackSearchRequest(
                new TripjackSearchRequest.SearchQuery(
                        request.cabinClass().name(),

                        new TripjackSearchRequest.PaxInfo(
                                String.valueOf(request.adults()),
                                String.valueOf(Objects.requireNonNullElse(request.children(), 0)),
                                String.valueOf(Objects.requireNonNullElse(request.infants(), 0))
                        ),

                        List.of(
                                new TripjackSearchRequest.RouteInfo(
                                        new TripjackSearchRequest.CityOrAirport(
                                                request.origin()
                                        ),
                                        new TripjackSearchRequest.CityOrAirport(
                                                request.destination()
                                        ),
                                        request.departureDate().toString()
                                )
                        ),

                        List.of()
                ),
                new TripjackSearchRequest.SearchModifiers(
                        true,
                        true,
                        "REGULAR"
                )
        );
    }
}
