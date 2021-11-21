package com.company.yavlash.service;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.InvalidMethodParameterException;
import com.company.yavlash.exception.TriangleNotExistException;
import com.company.yavlash.service.impl.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangleServiceImplTest {
    private TriangleService triangleService;
    private Triangle triangle;

    @Before
    public void init() {
        triangleService = new TriangleServiceImpl();
        triangle = new Triangle(new Point(2.0, 0.0), new Point(1.5, 2.0), new Point(4.5, 2.0));
    }

    @Test
    public void isTriangleTest_RelevantData() throws InvalidMethodParameterException {
        //given
        Triangle triangle = new Triangle(new Point(0,0), new Point (0, 4), new Point(4, 0));

        //when
        boolean actual = triangleService.isTriangle(triangle);

        //then
        Assert.assertTrue(actual);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isTriangleTest_IrrelevantTextType() throws InvalidMethodParameterException {
        //given && when && then
        triangleService.isTriangle(null);
    }

    @Test
    public void findSquareTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        double expected = 3.00;

        //when
        double actual = triangleService.findSquare(triangle);

        //then
        Assert.assertEquals(actual, expected, 3);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void findSquareTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.findSquare(null);
    }

    @Test
    public void findPerimeterTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        double expected = 8.26;

        //when
        double actual = triangleService.findPerimeter(triangle);

        //then
        Assert.assertEquals(actual, expected, 2);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void findPerimeterTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.findPerimeter(null);
    }

    @Test
    public void isIsoscelesTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        Triangle triangle = new Triangle(new Point(0,0), new Point (0, 4), new Point(4, 0));

        //when
        boolean actual = triangleService.isIsosceles(triangle);

        //then
        Assert.assertTrue(actual);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isIsoscelesTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isIsosceles(null);
    }

    @Test(expected = TriangleNotExistException.class)
    public void isIsoscelesTest_IrrelevantTriangle() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isIsosceles(new Triangle(new Point(0,0), new Point (0, 4), new Point(0, 10)));
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isEquilateralTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isEquilateral(null);
    }

    @Test(expected = TriangleNotExistException.class)
    public void isEquilateralTest_IrrelevantTriangle() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isEquilateral(new Triangle(new Point(0,0), new Point (0, 4), new Point(0, 10)));
    }

    @Test
    public void isRectangularTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        Triangle triangle = new Triangle(new Point(0,0), new Point (0, 4), new Point(4, 0));

        //when
        boolean actual = triangleService.isRectangular(triangle);

        //then
        Assert.assertTrue(actual);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isRectangularTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isRectangular(null);
    }

    @Test(expected = TriangleNotExistException.class)
    public void isRectangularTest_IrrelevantTriangle() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isRectangular(new Triangle(new Point(0,0), new Point (0, 4), new Point(0, 10)));
    }

    @Test
    public void isAcuteTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        Triangle triangle = new Triangle(new Point(0,0), new Point (0, 4), new Point(4, 0));

        //when
        boolean actual = triangleService.isAcute(triangle);

        //then
        Assert.assertTrue(actual);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isAcuteTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isAcute(null);
    }

    @Test(expected = TriangleNotExistException.class)
    public void isAcuteTest_IrrelevantTriangle() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isAcute(new Triangle(new Point(0,0), new Point (0, 4), new Point(0, 10)));
    }

    @Test
    public void isObtuseTest_RelevantData() throws TriangleNotExistException, InvalidMethodParameterException {
        //given
        Triangle triangle = new Triangle(new Point(2,-10), new Point (0, 0), new Point(0, 4));

        //when
        boolean actual = triangleService.isObtuse(triangle);

        //then
        Assert.assertTrue(actual);
    }

    @Test(expected = InvalidMethodParameterException.class)
    public void isObtuseTest_IrrelevantTextType() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isObtuse(null);
    }

    @Test(expected = TriangleNotExistException.class)
    public void isObtuseTest_IrrelevantTriangle() throws TriangleNotExistException, InvalidMethodParameterException {
        //given && when && then
        triangleService.isObtuse(new Triangle(new Point(0,0), new Point (0, 4), new Point(0, 10)));
    }
}