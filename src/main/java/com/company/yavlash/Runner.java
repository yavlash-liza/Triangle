package com.company.yavlash;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleParameters;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.factory.TriangleFactory;
import com.company.yavlash.parser.TriangleParser;
import com.company.yavlash.reader.TriangleReader;
import com.company.yavlash.service.TriangleService;
import com.company.yavlash.service.impl.TriangleServiceImpl;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws TriangleException {
        TriangleService triangleService = new TriangleServiceImpl();
        TriangleReader reader = new TriangleReader();
        List<String> strings = reader.readFile("./src/main/resources/data.txt");
        TriangleParser parser = new TriangleParser();
        TriangleFactory triangleFactory = new TriangleFactory();
        List<Triangle> triangles = triangleFactory.getTriangle(parser.parseStringListOfTrianglesToArray(strings));
        System.out.println(triangles);
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        triangles.forEach(triangle -> {
            try {
                double area = triangleService.findSquare(triangle);
                double perimeter = triangleService.findPerimeter(triangle);
                TriangleParameters triangleParameters = new TriangleParameters(perimeter, area);
                triangleWarehouse.put(triangle.getTriangleId(), triangleParameters);
            } catch (TriangleException e) {
                e.printStackTrace();
            }

        });
        triangles.sort(new Triangle.AreaComparator());
        System.out.println("-------------");
        System.out.println(triangles);
        triangles.sort(new Triangle.PerimeterComparator());
        System.out.println("-------------");
        System.out.println(triangles);
//        System.out.println(IdGenerator.generateId());
    }
}