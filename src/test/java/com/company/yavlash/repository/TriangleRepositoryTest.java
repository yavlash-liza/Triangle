package com.company.yavlash.repository;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleParameters;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.repository.impl.*;
import com.company.yavlash.service.TriangleService;
import com.company.yavlash.service.impl.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryTest {
    TriangleRepository triangleRepository;
    List<Triangle> triangles;
    TriangleService triangleService;
    TriangleWarehouse triangleWarehouse;

    @Before
    public void init() throws TriangleException {
        triangleService = new TriangleServiceImpl();
        triangleRepository = new TriangleRepository();
        triangles = new ArrayList<>() {{
            add(new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)));
            add(new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)));
            add(new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)));
            add(new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)));
            add(new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)));
            add(new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)));
            add(new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));
            add(new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)));
            add(new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)));
        }};
        triangleRepository.addAll(triangles);
        initWarehouse();
    }

    private void initWarehouse() throws TriangleException {
        triangleWarehouse = TriangleWarehouse.getInstance();
        for (Triangle triangles : triangles) {
            triangleWarehouse.put(triangles.getTriangleId(), new TriangleParameters(
                    triangleService.findPerimeter(triangles), triangleService.findArea(triangles))
            );
        }
    }

    @Test
    public void queryTest_IdSpecification_RelevantData() {
        //given
        Triangle expected = new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8));
        expected.setTriangleId(4L);

        //when
        Long id = 4L;
        Triangle actual = triangleRepository.query(new IdSpecification(id)).get(0);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_AreaSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)));

        //when
        double areaFrom = 3.0;
        double areaTo = 30;
        List<Triangle> actual = triangleRepository.query(new AreaSpecification(areaFrom, areaTo));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_PerimeterSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)));

        //when
        double perimeterFrom = 10;
        double perimeterTo = 20;
        List<Triangle> actual = triangleRepository.query(new PerimeterSpecification(perimeterFrom, perimeterTo));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_FirstQuadrantSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));

        //when
        List<Triangle> actual = triangleRepository.query(new FirstQuadrantSpecification());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_SecondQuadrantSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)));

        //when
        List<Triangle> actual = triangleRepository.query(new SecondQuadrantSpecification());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_ThirdQuadrantSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)));

        //when
        List<Triangle> actual = triangleRepository.query(new ThirdQuadrantSpecification());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void queryTest_FourthQuadrantSpecification_RelevantData() {
        //given
        List<Triangle> expected = List.of(new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)));

        //when
        List<Triangle> actual = triangleRepository.query(new FourthQuadrantSpecification());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_ById_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)),
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.IdComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_ByArea_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.AreaComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_ByPerimeter_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.PerimeterComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_ByFirstPoint_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.FirstPointComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_BySecondPoint_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.SecondPointComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest_ByThirdPoint_RelevantData() {
        //given
        List<Triangle> expected = List.of(
                new Triangle(new Point(-3.0, -3), new Point(-3, -3), new Point(-1, -3)),
                new Triangle(new Point(-20, 23), new Point(-3, 10.1), new Point(-14.7, 30.9)),
                new Triangle(new Point(-1.5, 1.5), new Point(-7, 1), new Point(-6, 1.5)),
                new Triangle(new Point(-3, -2), new Point(-0, -0), new Point(-7, -5)),
                new Triangle(new Point(18.0, 35.8), new Point(30.0, 15.0), new Point(10.7, 40.7)),
                new Triangle(new Point(6.5, -10), new Point(14.5, -20), new Point(20.4, -8)),
                new Triangle(new Point(0, 0), new Point(2, 4), new Point(5, 0)),
                new Triangle(new Point(1.5, 1.5), new Point(2.5, 6.5), new Point(5.5, 3.5)),
                new Triangle(new Point(54.9, 2.0), new Point(96.2, 29.5), new Point(67.9, 23.8)));

        //when
        List<Triangle> actual = triangleRepository.sort(new Triangle.ThirdPointComparator());

        //then
        Assert.assertEquals(expected, actual);
    }
}