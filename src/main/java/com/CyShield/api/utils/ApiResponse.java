package com.CyShield.api.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiResponse {

    private final Response response;


    public ApiResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public JsonPath getBody() {
        return response.jsonPath();
    }

    public <T> T getObjectFromBody(String path) {
        return response.jsonPath().get(path);
    }

    public long getTime() {
        return response.getTime();
    }

}
