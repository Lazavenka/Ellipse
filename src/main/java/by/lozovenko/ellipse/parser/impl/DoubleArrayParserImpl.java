package by.lozovenko.ellipse.parser.impl;

import by.lozovenko.ellipse.parser.DoubleArrayParser;
import by.lozovenko.ellipse.validator.StringDataValidator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleArrayParserImpl implements DoubleArrayParser {
    @Override
    public double[] parseData(String data) {
        StringDataValidator dataValidator = new StringDataValidator();
        List<String> stringNumbers = new ArrayList<>();
        if (dataValidator.validate(data)) {
            stringNumbers = Arrays.stream(data.split(StringDataValidator.DELIMITER_REGEX)).toList();
        }
        return stringNumbers.stream().mapToDouble(Double::parseDouble).toArray();
    }
}
