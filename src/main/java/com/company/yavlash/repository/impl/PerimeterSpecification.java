package com.company.yavlash.repository.impl;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.repository.TriangleSpecification;

public class PerimeterSpecification implements TriangleSpecification {
    private double fromPerimeter;
    private double toPerimeter;

    public PerimeterSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        return warehouse.get(triangle.getTriangleId()).getPerimeter() >= fromPerimeter &&
                warehouse.get(triangle.getTriangleId()).getPerimeter()<= toPerimeter;
    }
}