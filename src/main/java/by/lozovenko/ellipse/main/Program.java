package by.lozovenko.ellipse.main;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import by.lozovenko.ellipse.observer.impl.EllipseObserver;
import by.lozovenko.ellipse.parser.DoubleArrayParser;
import by.lozovenko.ellipse.reader.CustomFileReader;
import by.lozovenko.ellipse.reader.impl.CustomFileReaderImpl;
import by.lozovenko.ellipse.repository.EllipseRepository;
import by.lozovenko.ellipse.validator.EllipseValidator;
import by.lozovenko.ellipse.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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
        EllipseObserver observer = new EllipseObserver();
        ellipses.forEach(e -> e.attach(observer));
        ellipses.forEach(e -> Warehouse.getInstance().putParameters(e));
        EllipseRepository ellipseRepository = EllipseRepository.getInstance();
        ellipseRepository.addAll(ellipses);
        LOGGER.log(Level.INFO, ellipseRepository);
        try {
            ellipseRepository.get(0).setStartPoint(99,99);
            LOGGER.log(Level.INFO, ellipseRepository);
            LOGGER.log(Level.INFO, Warehouse.getInstance().getEllipseMap());
            ellipseRepository.get(0).setStartPoint(100, 100);
            LOGGER.log(Level.INFO, ellipseRepository);
            LOGGER.log(Level.INFO, Warehouse.getInstance().getEllipseMap());
            ellipseRepository.get(0).setEndPoint(98, 98);
            LOGGER.log(Level.INFO, ellipseRepository);
            LOGGER.log(Level.INFO, Warehouse.getInstance().getEllipseMap());
        } catch (ProjectException e) {
            LOGGER.debug("Incorrect coordinates", e);
        }
        LOGGER.log(Level.INFO, Warehouse.getInstance().getEllipseMap());
    }
}
