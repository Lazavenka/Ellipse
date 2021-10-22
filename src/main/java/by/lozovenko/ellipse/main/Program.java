package by.lozovenko.ellipse.main;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import by.lozovenko.ellipse.parser.DoubleArrayParser;
import by.lozovenko.ellipse.reader.CustomFileReader;
import by.lozovenko.ellipse.reader.impl.CustomFileReaderImpl;
import by.lozovenko.ellipse.validator.EllipseValidator;
import by.lozovenko.ellipse.validator.StringDataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DEFAULT_FILEPATH = "data/data.txt";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReaderImpl();
        DoubleArrayParser doubleArrayParser = new DoubleArrayParser();
        EllipseValidator ellipseValidator = new EllipseValidator();
        List<String> lines = fileReader.readLinesFromFile(DEFAULT_FILEPATH);
        List<Ellipse> ellipses = lines.stream()
                .map(doubleArrayParser::parseData)
                .filter(ellipseValidator::isValid)
                .map(doubles -> {
                    try {
                        return EllipseFactory.createEllipse(doubles);
                    } catch (ProjectException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .toList();
        ellipses.forEach(ellipse -> LOGGER.log(Level.INFO, ellipse.toString()));
    }
}
