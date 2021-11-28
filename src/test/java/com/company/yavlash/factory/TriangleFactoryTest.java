package com.company.yavlash.factory;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.TriangleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactoryTest {
    private TriangleFactory triangleFactory;
    private Triangle triangle;
    private List<Triangle> triangles;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    @Before
    public void init() {
        triangleFactory = new TriangleFactory();

        triangles = new ArrayList<>() {{
            add(new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2)));
            add(new Triangle(new Point(0, 0), new Point(-1, -1), new Point(-2, -2)));
        }};
        pointA = new Point(2.0, -9);
        pointB = new Point(0, 10);
        pointC = new Point(4, 7);

        triangle = new Triangle(pointA, pointB, pointC);
    }

    @Test
    public void getTriangleTest_ListDoubleArray_RelevantData() throws TriangleException {
        //given
        List<Triangle> expected = triangles;
        List<double[]> actualDoubleArray = new ArrayList<>() {{
            add(new double[] {0, 0, 1, 1, 2, 2});
            add(new double[] {0, 0, -1, -1, -2, -2});
        }};

        //when
        List<Triangle> actual = triangleFactory.getTriangle(actualDoubleArray);

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = TriangleException.class)
    public void getTriangleTest_ListDoubleArray_NullData() throws TriangleException {
        //given && when && then
        triangleFactory.getTriangle(null);
    }

    @Test
    public void getTriangleTest_ThreePoints_RelevantData() throws TriangleException{
        //given
        Triangle expected = triangle;
        
        //when
        Triangle actual = triangleFactory.getTriangle(pointA, pointB, pointC);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = TriangleException.class)
    public void getTriangleTest_ThreePoints_NullFirstPoint() throws TriangleException {
        //given && when && then
        triangleFactory.getTriangle(null, pointB, pointA);
    }

    @Test(expected = TriangleException.class)
    public void getTriangleTest_ThreePoints_NullSecondPoint() throws TriangleException {
        //given && when && then
        triangleFactory.getTriangle(pointA, null, pointB);
    }

    @Test(expected = TriangleException.class)
    public void getTriangleTest_ThreePoints_NullThirdPoint() throws TriangleException {
        //given && when && then
        triangleFactory.getTriangle(pointA, pointB, null);
    }
}