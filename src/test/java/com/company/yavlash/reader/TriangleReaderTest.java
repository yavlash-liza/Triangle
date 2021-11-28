package com.company.yavlash.reader;

import com.company.yavlash.exception.TriangleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TriangleReaderTest {
    private TriangleReader reader;
    private List<String> expected;
    private String filePath;

    @Before
    public void init() {
        reader = new TriangleReader();
        expected = List.of(
                "0.3 7.4 8.5 5.5 7.8 8.1",
                "",
                "75 53 89 74 12 45 89",
                "-3 -1 -9 -5 -8 -1",
                "",
                "9 9 5");
        filePath = "./src/test/resources/testData_reader.txt";
    }

    @Test
    public void readFileTest_RelevantData() throws TriangleException {
        //given && when
        List<String> actual = reader.readFile(filePath);

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = TriangleException.class)
    public void readFileTest_NullData() throws TriangleException {
        //given && when && then
        reader.readFile(null);
    }

    @Test(expected = TriangleException.class)
    public void readFileTest_EmptyFileName() throws TriangleException {
        //given && when && then
        reader.readFile(" ");
    }

    @Test(expected = TriangleException.class)
    public void readFileTest_WrongFile() throws TriangleException {
        //given && when
        String path = "resources";

        //then
        reader.readFile(path);
    }
}