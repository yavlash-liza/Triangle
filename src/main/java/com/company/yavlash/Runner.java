package com.company.yavlash;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.InvalidMethodParameterException;
import com.company.yavlash.util.TriangleParser;
import com.company.yavlash.util.TriangleReader;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws InvalidMethodParameterException {
        TriangleReader reader = new TriangleReader();
        List<String> strings = reader.readFile("src/main/resources/data.txt");
        TriangleParser parser = new TriangleParser();
        List<Triangle> triangles = parser.parseStringListToArray(strings);

        System.out.println(triangles);
    }
}