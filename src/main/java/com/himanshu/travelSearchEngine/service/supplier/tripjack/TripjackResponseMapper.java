package com.himanshu.travelSearchEngine.service.supplier.tripjack;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.JsonNode;
import com.himanshu.travelSearchEngine.dto.Flight;

public class TripjackResponseMapper {
    public static List<Flight> map(JsonNode response) {
        List<Flight> flights = new ArrayList<>();

        JsonNode tripInfos = response.path("searchResult").path("tripInfos");

        for (JsonNode tripInfo : tripInfos.path("ONWARD")) {
            flights.add(toFlight(tripInfo));
        }

        for (JsonNode tripInfo : tripInfos.path("RETURN")) {
            flights.add(toFlight(tripInfo));
        }

        return flights;
    }

    private static Flight toFlight(JsonNode tripInfo) {
        JsonNode segments = tripInfo.path("sI");
        JsonNode first = segments.path(0);
        JsonNode last = segments.path(segments.size() - 1);

        LocalDateTime departure = LocalDateTime.parse(first.path("dt").asString());
        LocalDateTime arrival = LocalDateTime.parse(last.path("at").asString());

        return new Flight(
                first.path("fD").path("aI").path("code").asString(),
                first.path("fD").path("fN").asString(),
                first.path("da").path("code").asString(),
                last.path("aa").path("code").asString(),
                departure.toLocalDate(),
                departure.toLocalTime(),
                arrival.toLocalTime(),
                tripInfo.path("totalPriceList").path(0).path("fd").path("ADULT").path("fC").path("TF").decimalValue(),
                "INR");
    }
}
