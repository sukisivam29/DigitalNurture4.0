package com.example;

public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void processLog(String message) {
        externalApi.logMessage(message); // void method call
    }
}
