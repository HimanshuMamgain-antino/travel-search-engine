package com.himanshu.travelSearchEngine.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HealthService {
    public Map<String, String> getHealth() {
        return Map.of(
                "status", "UP",
                "service", "travelSearchEngine"
        );
    }
}
