package com.himanshu.travelSearchEngine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SupplierException.class)
    public ResponseEntity<Map<String, Object>> handleSupplierException(SupplierException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("supplier", exception.getSupplier());
        body.put("retryable", exception.isRetryable());
        body.put("error", exception.getDetails());

        HttpStatus status = exception.getHttpStatus() >= 500 ? HttpStatus.BAD_GATEWAY
                : HttpStatus.valueOf(exception.getHttpStatus());

        return ResponseEntity.status(status).body(body);
    }
}
