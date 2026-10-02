package com.himanshu.travelSearchEngine.service;

import com.himanshu.travelSearchEngine.dto.CreateTravelRequest;
import com.himanshu.travelSearchEngine.dto.TravelResponse;
import com.himanshu.travelSearchEngine.exception.TravelNotFoundException;
import com.himanshu.travelSearchEngine.model.Travel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelService {
    private final List<Travel> travels = new ArrayList<>(List.of(
            new Travel(1L, "Delhi", "Mumbai"),
            new Travel(2L, "Delhi", "Bangalore"),
            new Travel(3L, "Mumbai", "Goa")
    ));

    private Long nextId = 4L;

    public List<TravelResponse> getTravels() {
        return travels.stream().map(travel -> new TravelResponse(
                travel.getId(),
                travel.getSource(),
                travel.getDestination()
        )).toList();
    }

    public TravelResponse getTravelById(Long id) {
        Travel travel = travels.stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(() -> new TravelNotFoundException(id));

        return new TravelResponse(travel.getId(), travel.getSource(), travel.getDestination());
    }

    public TravelResponse createTravel(CreateTravelRequest request) {
        Travel travel = new Travel(
                nextId++,
                request.getSource(),
                request.getDestination()
        );

        travels.add(travel);

        return new TravelResponse(
                travel.getId(),
                travel.getSource(),
                travel.getDestination()
        );
    }
}
