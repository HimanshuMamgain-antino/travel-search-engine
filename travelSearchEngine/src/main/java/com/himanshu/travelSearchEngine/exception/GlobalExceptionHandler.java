package com.himanshu.travelSearchEngine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SupplierException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Map<String, Object> handleSupplierException(
            SupplierException exception
    ) {
        return Map.of(
                "error", exception.getMessage(),
                "supplier", exception.getSupplier(),
                "retryable", exception.isRetryable()
        );
    }
}
