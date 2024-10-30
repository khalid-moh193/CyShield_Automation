package com.CyShield.api.apis;

import com.CyShield.api.utils.ApiResponse;
import com.CyShield.api.utils.ApiSpecificationHandler;
import io.restassured.RestAssured;

import java.util.Map;

public class BaseApi extends ApiSpecificationHandler {

    static String baseURI = "https://reqres.in/api/users";

    /*
    ################### POST ###################
     */
    protected static ApiResponse post(ApiPath path, Map<String, Object> requestBody) {
        return new ApiResponse(RestAssured.given().spec(requestSpec).log().all().
                when().
                baseUri(baseURI).
                body(requestBody).
                post(path.getValue()));
    }

    /*
    ################### PUT ###################
    */

    static ApiResponse put(ApiPath path, String param, Map<String, Object> requestBody) {
        return new ApiResponse(RestAssured.given().spec(requestSpec).log().all().
                baseUri(baseURI+ "/" + param).
                body(requestBody).
                put(path.getValue()));
    }

    /*
    ################### GET ###################
     */

    protected static ApiResponse get(String path, Map<String, Object> requestParameters,
                                     Map<String, String> requestHeaders) {
        return new ApiResponse(RestAssured.given().spec(requestSpec).log().all().
                when().headers(requestHeaders).
                baseUri(baseURI).
                params(requestParameters).
                get(path));
    }


}