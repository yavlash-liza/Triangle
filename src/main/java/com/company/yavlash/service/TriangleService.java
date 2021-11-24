package com.company.yavlash.service;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.TriangleException;

public interface TriangleService {
    double findSquare(Triangle triangle) throws TriangleException;
    double findPerimeter(Triangle triangle) throws TriangleException;
    boolean isIsosceles(Triangle triangle) throws TriangleException;
    boolean isEquilateral(Triangle triangle) throws TriangleException;
    boolean isRectangular(Triangle triangle) throws TriangleException;
    boolean isAcute(Triangle triangle) throws TriangleException;
    boolean isObtuse(Triangle triangle) throws TriangleException;
}