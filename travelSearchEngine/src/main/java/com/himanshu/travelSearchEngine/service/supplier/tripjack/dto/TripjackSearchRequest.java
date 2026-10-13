package com.himanshu.travelSearchEngine.service.supplier.tripjack.dto;

import java.util.List;

public record TripjackSearchRequest(
    SearchQuery searchQuery,
    SearchModifiers searchModifiers
) {
    public record SearchQuery(
            String cabinClass,
            PaxInfo paxInfo,
            List<RouteInfo> routeInfos,
            List<CorporateCode> corporateCodes
    ) {
    }

    public record PaxInfo(
            String ADULT,
            String CHILD,
            String INFANT
    ) {
    }

    public record RouteInfo(
            CityOrAirport fromCityOrAirport,
            CityOrAirport toCityOrAirport,
            String travelDate
    ) {
    }

    public record CityOrAirport(
            String code
    ) {
    }

    public record CorporateCode(
            String pcc,
            List<AirlineKeys> airlineKeys
    ) {
    }

    public record AirlineKeys(
            String airline,
            String corporateCode
    ) {
    }

    public record SearchModifiers(
            boolean isDirectFlight,
            boolean isConnectingFlight,
            String pft
    ) {
    }
}
