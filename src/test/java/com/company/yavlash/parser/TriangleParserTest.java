package com.company.yavlash.parser;

import com.company.yavlash.exception.TriangleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleParserTest {
    private TriangleParser parser;
    private List<String> data;
    private List<double[]> expected;

    @Before
    public void init() {
        parser = new TriangleParser();
        data = List.of(
                "0.3 7.4 8.5 5.5 7.8 8.1",
                "",
                "75 53 89 74 12 45 89",
                "-3 -1 -9 -5 -8 -1",
                "",
                "9 9 5");
        expected = new ArrayList<>() {{
            add(new double[]{0.3, 7.4, 8.5, 5.5, 7.8, 8.1});
            add(new double[]{-3, -1, -9, -5, -8, -1});
        }};
    }

    @Test
    public void parseStringListOfTrianglesToArrayTest_RelevantData() throws TriangleException {
        //given
        List<List<Double>> expected = construct(this.expected);

        //when
        List<List<Double>> actual = construct(parser.parseStringListOfTrianglesToArray(data));

        //then
        Assert.assertEquals(actual, expected);
    }

    private List<List<Double>> construct(List<double[]> result) {
        return result.stream()
                .map(this::constructListDouble)
                .collect(Collectors.toList());
    }

    private List<Double> constructListDouble(double[] array) {
        List<Double> list = new ArrayList<>();
        for (double value : array) {
            list.add(value);
        }
        return list;
    }

    @Test(expected = TriangleException.class)
    public void parseStringListOfTrianglesToArrayTest_NullData() throws TriangleException {
        //given && when && then
        parser.parseStringListOfTrianglesToArray(null);
    }
}