package com.CyShield.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class ApiSpecificationHandler {

    protected static final RequestSpecification requestSpec = new RequestSpecBuilder().
            addHeader("Content-Type", "application/json").
            build();

}
