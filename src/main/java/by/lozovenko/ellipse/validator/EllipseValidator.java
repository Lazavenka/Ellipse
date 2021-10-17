package by.lozovenko.ellipse.validator;

import by.lozovenko.ellipse.entity.Point2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final int COORDINATES_COUNT = 4;
    public static final int COORDINATE_START_POINT_X = 0;
    public static final int COORDINATE_START_POINT_Y = 1;
    public static final int COORDINATE_END_POINT_X = 2;
    public static final int COORDINATE_END_POINT_Y = 3;

    public boolean isValid(double[] coordinates){
        boolean result = coordinates!=null && coordinates.length == COORDINATES_COUNT &&
                !(coordinates[COORDINATE_START_POINT_X]==coordinates[COORDINATE_END_POINT_X]||
                        coordinates[COORDINATE_START_POINT_Y]==coordinates[COORDINATE_END_POINT_Y]);
        LOGGER.debug("Coordinates {} valid for ellipse - {}", coordinates, result);
        return result;
    }
    public boolean isValid(Point2D startPoint, Point2D endPoint){
        boolean result = Double.compare(startPoint.getX(), endPoint.getX()) != 0 &&
                Double.compare(startPoint.getY(), endPoint.getY()) != 0;
        LOGGER.debug("Points ({};{}) valid for ellipse - {}", startPoint, endPoint, result);
        return result;
    }
}
