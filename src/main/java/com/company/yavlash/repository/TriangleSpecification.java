package com.company.yavlash.repository;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.TriangleException;

@FunctionalInterface
public interface TriangleSpecification {
    boolean specify(Triangle triangle);
}