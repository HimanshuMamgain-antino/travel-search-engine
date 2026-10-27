package com.himanshu.travelSearchEngine.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record Flight(
        String airline,
        String flightNumber,
        String origin,
        String destination,
        LocalDate departureDate,
        LocalTime departureTime,
        LocalTime arrivalTime,
        BigDecimal price,
        String currency) {
}
