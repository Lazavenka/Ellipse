package by.lozovenko.ellipse.factory;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.entity.Point2D;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.parser.DoubleArrayParser;
import by.lozovenko.ellipse.util.EllipsePointSwitcher;
import by.lozovenko.ellipse.validator.EllipseValidator;

public class EllipseFactory {

    private EllipseFactory() {
    }

    public static Ellipse createEllipse(Point2D startPoint, Point2D endPoint) throws ProjectException {
        EllipseValidator ellipseValidator = new EllipseValidator();
        if ((startPoint == null || endPoint == null) || !ellipseValidator.isValid(startPoint, endPoint)) {
            throw new ProjectException("Illegal argument!");
        }
        if (EllipsePointSwitcher.isNeedSwitchPoints(startPoint, endPoint)){
            EllipsePointSwitcher.switchPoints(startPoint, endPoint);
        }
        return new Ellipse(startPoint, endPoint);
    }

    public static Ellipse createEllipse(double... coordinates) throws ProjectException {
        EllipseValidator ellipseValidator = new EllipseValidator();

        if (coordinates == null || !ellipseValidator.isValid(coordinates)) {
            throw new ProjectException("Illegal argument!");
        }
        double leftLowX = coordinates[EllipseValidator.COORDINATE_START_POINT_X];
        double leftLowY = coordinates[EllipseValidator.COORDINATE_START_POINT_Y];
        double rightUpX = coordinates[EllipseValidator.COORDINATE_END_POINT_X];
        double rightUpY = coordinates[EllipseValidator.COORDINATE_END_POINT_Y];

        return createEllipse(leftLowX, leftLowY, rightUpX, rightUpY);
    }

    public static Ellipse createEllipse(String line) throws ProjectException {
        DoubleArrayParser parser = new DoubleArrayParser();
        double[] coordinates = parser.parseData(line);
        return createEllipse(coordinates);
    }

    private static Ellipse createEllipse(double startPointX, double startPointY,
                                         double endPointX, double endPointY) {
        double leftLowX = Math.min(startPointX, endPointX);
        double leftLowY = Math.min(startPointY, endPointY);
        double rightUpX = Math.max(startPointX, endPointX);
        double rightUpY = Math.max(startPointY, endPointY);
        Point2D startPoint = new Point2D(leftLowX, leftLowY);
        Point2D endPoint = new Point2D(rightUpX, rightUpY);
        return new Ellipse(startPoint, endPoint);
    }
}
