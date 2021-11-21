package com.company.yavlash.validator;

public class TriangleValidator {
    private static final String TRIANGLE_DATA_REGEX = "^-?\\d+(\\.\\d+)?(\\s+-?\\d+(\\.\\d+)?){5}$";

    private TriangleValidator() {
    }

    public static boolean isTriangleData(String data) {
        return data.matches(TRIANGLE_DATA_REGEX);
    }
}