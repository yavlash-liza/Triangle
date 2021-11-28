package com.company.yavlash.repository;

import com.company.yavlash.entity.Triangle;

@FunctionalInterface
public interface TriangleSpecification {
    boolean specify(Triangle triangle);
}