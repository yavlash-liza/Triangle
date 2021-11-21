package com.company.yavlash.util;

import com.company.yavlash.exception.InvalidMethodParameterException;
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

    public List<String> readFile(String path) throws InvalidMethodParameterException {
        if (path == null || path.isBlank()) {
            throw new InvalidMethodParameterException(String.format("File name %s is null or blank", path));
        }
        Path dataFile = Paths.get(path);
        try (Stream<String> dataStream = Files.lines(dataFile)){
            List<String> doubleStringList = dataStream
                    .collect(Collectors.toList());
            logger.log(Level.INFO, "Read file {} is successful", dataFile.getFileName());
            return doubleStringList;
        } catch (IOException e) {
            throw new InvalidMethodParameterException(String.format("Input error during reading file %s", dataFile.getFileName()), e);
        }
    }
}