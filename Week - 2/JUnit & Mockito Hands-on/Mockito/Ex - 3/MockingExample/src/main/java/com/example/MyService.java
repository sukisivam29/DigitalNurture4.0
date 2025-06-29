package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    // New method
    public void pushData(String data) {
        externalApi.sendData(data); // Call to be verified
    }
}
