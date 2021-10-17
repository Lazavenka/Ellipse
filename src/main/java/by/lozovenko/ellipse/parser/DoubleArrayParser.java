package by.lozovenko.ellipse.parser;

import by.lozovenko.ellipse.validator.StringDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleArrayParser {
    private static final Logger LOGGER = LogManager.getLogger();
    public double[] parseData(String data){
        StringDataValidator dataValidator = new StringDataValidator();
        List<String> stringNumbers = new ArrayList<>();
        if (dataValidator.validate(data)){
            stringNumbers = Arrays.stream(data.split(StringDataValidator.DELIMITER_REGEX)).toList();
            LOGGER.debug(stringNumbers); //TODO clean unnecessary debug logs
        }
        return stringNumbers.stream().mapToDouble(Double::parseDouble).toArray();
    }
}
