package com.company.yavlash.service.impl;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.service.TriangleService;

import java.util.ArrayList;
import java.util.List;

public class TriangleServiceImpl implements TriangleService {
    private static final String ERROR_MESSAGE = "Error data! Null triangle!";

    @Override
    public double findSquare(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        double halfPerimeter = findPerimeter(triangle) * 0.5;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sides.get(0))
                * (halfPerimeter - sides.get(1)) * (halfPerimeter - sides.get(2)));
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

    @Override
    public double findPerimeter(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        return sides.stream().mapToDouble(side -> side).sum();
    }

    @Override
    public boolean isIsosceles(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        return checkEquality(sides.get(0), sides.get(1)) || checkEquality(sides.get(0), sides.get(2))
                || checkEquality(sides.get(1), sides.get(2));
    }

    private boolean checkEquality(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    @Override
    public boolean isEquilateral(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        return checkEquality(sides.get(0), sides.get(1)) && checkEquality(sides.get(0), sides.get(2));
    }

    @Override
    public boolean isRectangular(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        boolean first = sides.get(0) == Math.sqrt(Math.pow(sides.get(1), 2) + Math.pow(sides.get(2), 2));
        boolean second = sides.get(1) == Math.sqrt(Math.pow(sides.get(0), 2) + Math.pow(sides.get(2), 2));
        boolean third = sides.get(2) == Math.sqrt(Math.pow(sides.get(1), 2) + Math.pow(sides.get(0), 2));
        return first || second || third;
    }

    @Override
    public boolean isAcute(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        return Math.pow(sides.get(0), 2) + Math.pow(sides.get(1), 2) > Math.pow(sides.get(2), 2);
    }

    @Override
    public boolean isObtuse(Triangle triangle) throws TriangleException {
        if (triangle == null) {
            throw new TriangleException(ERROR_MESSAGE);
        }
        List<Double> sides = findSides(triangle);
        return Math.pow(sides.get(0), 2) + Math.pow(sides.get(1), 2) < Math.pow(sides.get(2), 2);
    }
}