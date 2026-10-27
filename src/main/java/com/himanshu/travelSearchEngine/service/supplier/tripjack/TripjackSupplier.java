package com.himanshu.travelSearchEngine.service.supplier.tripjack;

import com.himanshu.travelSearchEngine.dto.Flight;
import com.himanshu.travelSearchEngine.dto.FlightSearchRequest;
import com.himanshu.travelSearchEngine.exception.SupplierException;
import com.himanshu.travelSearchEngine.service.supplier.FlightSupplier;
import com.himanshu.travelSearchEngine.service.supplier.SupplierCode;
import com.himanshu.travelSearchEngine.service.supplier.tripjack.dto.TripjackSearchRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import tools.jackson.databind.JsonNode;

@Service
public class TripjackSupplier implements FlightSupplier {
    private final WebClient webClient;
    private final String apiKey;

    public TripjackSupplier(
            WebClient.Builder builder,
            @Value("${tripjack.base-url}") String baseUrl,
            @Value("${tripjack.api-key}") String apiKey

    ) {
        this.apiKey = apiKey;
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    @Override
    public SupplierCode getCode() {
        return SupplierCode.TRIPJACK;
    }

    @Override
    public List<Flight> search(FlightSearchRequest request) {
        TripjackSearchRequest tripjackSearchRequest = TripjackRequestMapper.map(request);

        try {
            JsonNode response = webClient
                    .post()
                    .uri("/fms/v1/air-search-all")
                    .header("apiKey", apiKey)
                    .header("Content-type", "application/json")
                    .bodyValue(tripjackSearchRequest)
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .block();

            return TripjackResponseMapper.map(response);
        } catch (WebClientResponseException exception) {
            throw new SupplierException(
                    "TRIPJACK",
                    "Tripjack request failed: " + exception.getStatusCode(),
                    exception.getStatusCode().is5xxServerError(),
                    exception.getStatusCode().value(),
                    exception.getResponseBodyAs(JsonNode.class));
        }
    }
}
