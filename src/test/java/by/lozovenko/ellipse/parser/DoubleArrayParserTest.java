package by.lozovenko.ellipse.parser;

import by.lozovenko.ellipse.parser.impl.DoubleArrayParserImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoubleArrayParserTest {
    DoubleArrayParser doubleArrayParser = new DoubleArrayParserImpl();

    @Test
    public void testParseData() {
        String stringData = "1.2 2.3 5.6 3.3";
        double[] expectedData = {1.2, 2.3, 5.6, 3.3};
        double[] actual = doubleArrayParser.parseData(stringData);

        assertEquals(actual, expectedData);
    }

    @Test
    public void testParseDataIncorrectData() {
        String stringData = "1.2 2.3 5.6 3.f3";
        double[] expectedData = {};
        double[] actual = doubleArrayParser.parseData(stringData);

        assertEquals(actual, expectedData);
    }

    @Test
    public void testParseDataThreeNumbers() {
        String stringData = "1.2 2.3 5.6";
        double[] expectedData = {1.2, 2.3, 5.6};
        double[] actual = doubleArrayParser.parseData(stringData);

        assertEquals(actual, expectedData);
    }

}