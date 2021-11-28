package com.company.yavlash.validator.impl;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.validator.TriangleValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TriangleValidatorImpl implements TriangleValidator {
    private static final String TRIANGLE_DATA_REGEX = "^-?\\d+(\\.\\d+)?(\\s+-?\\d+(\\.\\d+)?){5}$"; //исправить(выделить повторябщую часть отдельно)

    public TriangleValidatorImpl() {
    }

    @Override
    public boolean isTriangleDataValid(String data) {
        return data.matches(TRIANGLE_DATA_REGEX);
    }

    @Override
    public boolean isFilePathValid(String filepath) {
        boolean isValid = false;
        if (filepath != null) {
            File file = new File(filepath);
            isValid = file.exists() && (file.length() != 0);
        }
        return isValid;
    }

    @Override
    public boolean isTriangle(Triangle triangle){
        if (triangle == null || triangle.getPointA() == null || triangle.getPointB() == null || triangle.getPointC() == null) {
            return false;
        }
        List<Double> sides = findSides(triangle);
        double first = sides.get(0);
        double second = sides.get(1);
        double third = sides.get(2);
        return first < second + third && second < first + third && third < second + first;
    }

    private List<Double> findSides(Triangle triangle) {
        return new ArrayList<>() {{
            add(findSide(triangle.getPointA(), triangle.getPointB()));
            add(findSide(triangle.getPointB(), triangle.getPointC()));
            add(findSide(triangle.getPointA(), triangle.getPointC()));
        }};
    }

    private double findSide(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
    }
}