package com.company.yavlash.validator;

import com.company.yavlash.entity.Triangle;

public interface TriangleValidator {
    boolean isTriangleDataValid(String data);
    boolean isFilePathValid(String filepath);
    boolean isTriangle(Triangle triangle);
}