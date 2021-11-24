package com.company.yavlash.repository.impl;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.repository.TriangleSpecification;

public class AreaSpecification implements TriangleSpecification {
    private double fromArea;
    private double toArea;

    public AreaSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        return warehouse.get(triangle.getTriangleId()).getArea() >= fromArea &&
                warehouse.get(triangle.getTriangleId()).getArea()<= toArea;
    }
}