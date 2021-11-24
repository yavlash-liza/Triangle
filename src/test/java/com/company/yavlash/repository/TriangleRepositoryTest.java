package com.company.yavlash.repository;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.service.TriangleService;
import com.company.yavlash.service.impl.TriangleServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TriangleRepositoryTest {
//    TriangleRepository triangleRepository;
//    List<Triangle> queryTriangles;
//    List<Triangle> sortTriangles;
//    TriangleService triangleService;
//    TriangleWarehouse triangleWarehouse;
//
//    @Before
//    public void setUp() throws TriangleException {
//        triangleService = new TriangleServiceImpl();
//        triangleWarehouse = TriangleWarehouse.getInstance();
//        triangleRepository = TriangleRepository.getInstance();
//
//        queryTriangles = List.of(
//                new Triangle(new Point(7.9, 0.8), new Point(2.5, 6.4), new Point (6.5, 3.4)),
//                new Triangle(new Point(-9.26, 1.5), new Point(-7.9, 1.1), new Point (-0.8, 1.2)),
//                new Triangle(new Point(0.0, 0.0), new Point(2.5, 4.33), new Point (5.0, 0.0)),
//                new Triangle(new Point(-10, -12), new Point(-5, -7.5), new Point (-2.0, -12)),
//                new Triangle(new Point(8.3, -15), new Point(10.5, -11.1), new Point (17.6, -16.2)),
//                new Triangle(new Point(-3.0, -3), new Point(-3, 3.2), new Point (1.8, -3)),
//                new Triangle(new Point(1.0, 53), new Point(89.0, 74.0), new Point (12.7, 45)),
//                new Triangle(new Point(1.0, 8.0), new Point(45.3, 7.0), new Point (15.7, 78.3)),
//                new Triangle(new Point(9.0, 45.3), new Point(0.8, 15.0), new Point (13.2, 7.0)),
//                new Triangle(new Point(3.2, 2.0), new Point(0.0, 0.0), new Point (7.0, 5.0)),
//                new Triangle(new Point(-3.0, 7.0), new Point(-1.2, 13.76), new Point (0.6, 7.0)),
//                new Triangle(new Point(3.5, -20), new Point(11.0, -7.01), new Point (18.5, -20.0)),
//                new Triangle(new Point(3.0, 8.0), new Point(8.8, 16.0), new Point (18.0, 8.8)),
//                new Triangle(new Point(-15.83, 10.2), new Point(-11.0, 11.0), new Point (-7.83, 10.2));
//        );
//        triangleQueryRepository.addAll(queryTriangles);
//        triangleQueryRepository.add(null);
//
//        triangleRepository = new TriangleRepository();
//        sortTriangles = new ArrayList<>();
//        Triangle triangle = new Triangle(new Point(8.3, 17.5), new Point(12.0, 16.0), new Point (18.0, 7.3));
//        sortTriangles.add(new Triangle(new Point(3.0, 8.0), new Point(8.8, 16.0), new Point (18.0, 8.8)));
//        sortTriangles.add(new Triangle(new Point(-10, -12), new Point(-5, -7.5), new Point (-2.0, -12)));
//        sortTriangles.add(new Triangle(new Point(-10, -7), new Point(-3.2, 6.2), new Point (4.8, -4.8)));
//        sortTriangles.add(new Triangle(new Point(2.5, 3.4), new Point(-5, 0.0), new Point (6.5, 3.4)));
//        sortTriangles.add(new Triangle(new Point(3.0, 8.0), new Point(8.8, 16.0), new Point (18.0, 8.8)));
//        sortTriangles.add(triangle);
//
//        for (Triangle triangles : sortTriangles) {
//            triangleWarehouse.putParameters(
//                    triangles.getTriangleId(), new TriangleParameters(triangleService.calculatePerimeter(triangles).getAsDouble(),
//                            triangleService.calculateArea(triangles).getAsDouble()));
//        }
//
//        sortTriangles.add(null);
//        triangleRepository.addAll(sortTriangles);
//    }
//    @Test
//    public void query() {
//    }
}