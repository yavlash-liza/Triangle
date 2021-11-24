package com.company.yavlash.factory;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.TriangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final int VALID_AMOUNT_OF_POINTS = 6;

    public List<Triangle> getTriangle(List<double[]> parameters) throws TriangleException{
        if(parameters == null || parameters.isEmpty()) {
            logger.log(Level.WARN,"Invalid parameters {} in factory", parameters);
            throw new TriangleException(String.format("Invalid triangle parameters! %s", parameters));
        }
        List<Triangle> triangles = new ArrayList<>();
        for(double[] array : parameters) {
            triangles.add(getTriangle(array));
        }
        return triangles;
    }

    public Triangle getTriangle(double[] array) throws TriangleException {
        if( array.length != VALID_AMOUNT_OF_POINTS) {
            logger.log(Level.WARN,"Invalid count of points {} in factory", array.length);
            throw new TriangleException(String.format("Invalid count of points! %s", array.length));
        }
        return  getTriangle(array[0], array[1], array[2], array[3], array[4], array[5]);
    }

    public Triangle getTriangle(double x1, double y1, double x2, double y2, double x3, double y3) throws TriangleException {
        Point pointA = new Point(x1, y1);
        Point pointB = new Point(x2, y2);
        Point pointC = new Point(x3, y3);
        Triangle triangle = getTriangle(pointA, pointB, pointC);
        logger.log(Level.INFO,"New triangle {} was created", triangle);
        return triangle;
    }

    public Triangle getTriangle(Point pointA, Point pointB, Point pointC) throws TriangleException {
        if (pointA == null || pointB == null || pointC == null){
            logger.log(Level.WARN,"Invalid parameters {}, {}, {} in factory", pointA, pointB, pointC);
            throw new TriangleException(String.format("Invalid triangle parameters! %s, %s, %s", pointA, pointB, pointC));
        }
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        logger.log(Level.INFO,"New triangle {} was created", triangle);
        return triangle;
    }
}