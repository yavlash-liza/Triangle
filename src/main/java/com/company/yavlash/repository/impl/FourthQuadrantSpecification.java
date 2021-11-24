package com.company.yavlash.repository.impl;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.repository.TriangleSpecification;

public class FourthQuadrantSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        boolean pointA = triangle.getPointA().getX() > 0 && triangle.getPointA().getY() < 0;
        boolean pointB = triangle.getPointC().getX() > 0 && triangle.getPointC().getY() < 0;
        boolean pointC = triangle.getPointB().getX() > 0 && triangle.getPointB().getY() < 0;
        return pointA && pointB && pointC;
    }
}