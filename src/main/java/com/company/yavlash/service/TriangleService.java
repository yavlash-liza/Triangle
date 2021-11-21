package com.company.yavlash.service;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.InvalidMethodParameterException;
import com.company.yavlash.exception.TriangleNotExistException;

public interface TriangleService {
    boolean isTriangle(Triangle triangle) throws InvalidMethodParameterException;
    double findSquare(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    double findPerimeter(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    boolean isIsosceles(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    boolean isEquilateral(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    boolean isRectangular(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    boolean isAcute(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
    boolean isObtuse(Triangle triangle) throws TriangleNotExistException, InvalidMethodParameterException;
}