package com.example.exam.utils;

public enum ResponseStatus {
    SUCCESS("success"),
    FAIL("fail"),
    ERROR("error");
    private String value;

    ResponseStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
