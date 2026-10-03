package com.himanshu.travelSearchEngine.service.supplier.tripjack.dto;

import java.util.List;

public record TripjackSearchResponse(
        Status status,
        List<TripjackError> errors
) {
    public record Status(
            boolean success,
            int httpStatus
    ) {}

    public record TripjackError(
            String errcode,
            String message
    ) {}
}
