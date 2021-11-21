package com.company.yavlash.util;

import com.company.yavlash.entity.Point;
import com.company.yavlash.entity.Triangle;
import com.company.yavlash.exception.InvalidMethodParameterException;
import com.company.yavlash.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER_REGEX = "\\s+";

    public List<Triangle>  parseStringListToArray(List<String> parameters) throws InvalidMethodParameterException {
        if (parameters == null || parameters.isEmpty()) {
            throw new InvalidMethodParameterException("List is null or has not any parameters");
        }
        List<Triangle> triangles = parameters.stream()
                .map(String::trim)
                .filter(TriangleValidator::isTriangleData)
                .map(parametersLine -> parametersLine.split(SPACE_DELIMITER_REGEX))
                .map(array -> Stream.of(array)
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .map(this::construct)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "Parsing is successful");
        return triangles;
    }

    private Triangle construct(double[] parameters) {
        return new Triangle(
                new Point(parameters[0], parameters[1]),
                new Point(parameters[2], parameters[3]),
                new Point(parameters[4], parameters[5])
        );
    }
}