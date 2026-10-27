package com.himanshu.travelSearchEngine.exception;

import tools.jackson.databind.JsonNode;

import lombok.Getter;

@Getter
public class SupplierException extends RuntimeException {
    private final String supplier;
    private final boolean retryable;
    private final int httpStatus;
    private final JsonNode details;

    public SupplierException(
            String supplier,
            String message,
            boolean retryable,
            int httpStatus,
            JsonNode details) {
        super(message);
        this.supplier = supplier;
        this.retryable = retryable;
        this.httpStatus = httpStatus;
        this.details = details;
    }
}
