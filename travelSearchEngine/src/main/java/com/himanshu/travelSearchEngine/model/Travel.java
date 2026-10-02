package com.himanshu.travelSearchEngine.model;

import lombok.Getter;

@Getter
public class Travel {
    private final Long id;
    private final String source;
    private final String destination;

    public Travel(Long id, String source, String destination) {
        this.id = id;
        this.source = source;
        this.destination = destination;
    }
}
