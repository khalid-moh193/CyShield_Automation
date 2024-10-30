package com.CyShield.api.apis;

public enum ApiPath {
    LIST_USERS("?page="),
    CREATE_USER(""),
    UPDATE_USER("");

    private final String value;

    ApiPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}