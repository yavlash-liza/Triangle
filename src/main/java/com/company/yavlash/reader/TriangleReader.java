package com.company.yavlash.reader;

import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.validator.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleReader {
    private static final Logger logger = LogManager.getLogger();
    TriangleValidatorImpl validator = new TriangleValidatorImpl();

    public List<String> readFile(String path) throws TriangleException {
        if (!validator.isFilePathValid(path) || path.isBlank()) {
            throw new TriangleException(String.format("File name (%s) is blank or file path is invalid", path));
        }
        Path dataFile = Paths.get(path);
        try (Stream<String> dataStream = Files.lines(dataFile)){
            List<String> doubleStringList = dataStream
                    .collect(Collectors.toList());
            logger.log(Level.INFO, "Read file {} is successful", dataFile.getFileName());
            return doubleStringList;
        } catch (IOException e) {
            logger.log(Level.WARN, "Reading file {} is not successful", dataFile.getFileName());
            throw new TriangleException(String.format("Input error during reading file %s", dataFile.getFileName()), e);
        }
    }
}