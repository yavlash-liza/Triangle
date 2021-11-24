package com.company.yavlash.repository.impl;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.repository.TriangleSpecification;

public class IdSpecification implements TriangleSpecification {
    private Long id;

    public IdSpecification(Long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Triangle triangle) {
        return id != null ? id.equals(triangle.getTriangleId()) : null == triangle.getTriangleId();
    }
}