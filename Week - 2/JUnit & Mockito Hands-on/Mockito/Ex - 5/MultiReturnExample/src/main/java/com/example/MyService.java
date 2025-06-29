package com.example;

public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String[] checkStatusTwice() {
        String first = externalApi.getStatus();
        String second = externalApi.getStatus();
        return new String[]{first, second};
    }
}
