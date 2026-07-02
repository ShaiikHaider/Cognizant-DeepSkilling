package com.example;

/**
 * A simple service that fetches data from an ExternalApi.
 * The dependency is injected through the constructor, which is what
 * makes it easy to swap in a Mockito mock during testing.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}
