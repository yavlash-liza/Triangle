package com.company.yavlash.parser;

import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.validator.TriangleValidator;
import com.company.yavlash.validator.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER_REGEX = "\\s+";
    TriangleValidator validator = new TriangleValidatorImpl();

    public List<double[]>  parseStringListOfTrianglesToArray(List<String> parameters) throws TriangleException {
        if (parameters == null || parameters.isEmpty()) {
            logger.log(Level.WARN, "Parsing is not successful");
            throw new TriangleException("List is null or has not any parameters");
        }

        List<double[]> doubleParameters = parameters.stream()
                .map(String::trim)
                .filter(validator::isTriangleDataValid)
                .map(parametersLine -> parametersLine.split(SPACE_DELIMITER_REGEX))
                .map(array -> Stream.of(array)
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .collect(Collectors.toList());
        logger.log(Level.INFO, "Parsing is successful");
        return doubleParameters;
    }
}