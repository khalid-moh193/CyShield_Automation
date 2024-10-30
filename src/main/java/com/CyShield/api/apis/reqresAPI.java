package com.CyShield.api.apis;

import com.CyShield.api.utils.ApiResponse;

import java.util.HashMap;
import java.util.Map;


public class reqresAPI extends BaseApi {


    public static ApiResponse getUsers(Object page) {
        return get(ApiPath.LIST_USERS.getValue() + page, new HashMap<>(), new HashMap<>());
    }

    public static ApiResponse createUser(String name, String job) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);
        return post(ApiPath.CREATE_USER, requestBody);
    }

    public static ApiResponse updateUser(String userIdParam, String name, String job) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);
        return put(ApiPath.UPDATE_USER, userIdParam , requestBody);
    }


}