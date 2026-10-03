package com.himanshu.travelSearchEngine.exception;

import lombok.Getter;

@Getter
public class SupplierException extends RuntimeException {
    private final String supplier;
    private final boolean retryable;

    public SupplierException(
            String supplier,
            String message,
            boolean retryable
    ) {
        super(message);
        this.supplier = supplier;
        this.retryable = retryable;
    }
}
