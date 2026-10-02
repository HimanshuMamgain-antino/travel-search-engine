package com.himanshu.travelSearchEngine.exception;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(Long id) {
        super("Travel not found with id: " + id);
    }
}
