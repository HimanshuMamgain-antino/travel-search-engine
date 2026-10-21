package com.himanshu.travelSearchEngine.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record FlightSearchRequest(
        @NotBlank(message = "Origin is required")
        @Pattern(
                regexp = "^[A-Z]{3}$",
                message = "Origin must be a 3-letter airport code"
        )
        String origin,

        @NotBlank(message = "Destination is required")
        @Pattern(
                regexp = "^[A-Z]{3}$",
                message = "Destination must be a 3-letter airport code"
        )
        String destination,

        @NotNull(message = "Departure date is required")
        LocalDate departureDate,

        @NotNull(message = "Adults is required")
        @Min(value = 1, message = "At least one adult is required")
        Integer adults,

        @Min(value = 0, message = "Children cannot be negative")
        Integer children,

        @Min(value = 0, message = "Infants cannot be negative")
        Integer infants,

        @NotNull(message = "Cabin class is required")
        CabinClass cabinClass
) {
}
