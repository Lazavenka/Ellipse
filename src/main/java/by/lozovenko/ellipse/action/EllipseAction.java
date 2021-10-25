package by.lozovenko.ellipse.action;

import by.lozovenko.ellipse.entity.Ellipse;

public class EllipseAction {
    private static EllipseAction INSTANCE;

    private EllipseAction() {
    }

    public static EllipseAction getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EllipseAction();
        }
        return INSTANCE;
    }

    public double calculateEccentricity(Ellipse ellipse) {
        double a = getHalfWidth(ellipse);
        double b = getHalfHeight(ellipse);
        double minorAxis = Math.min(a, b);
        double majorAxis = Math.max(a, b);
        return Math.sqrt(1 - Math.pow(minorAxis, 2) / Math.pow(majorAxis, 2));
    }

    public double calculatePerimeter(Ellipse ellipse) {
        double a = getHalfWidth(ellipse);
        double b = getHalfHeight(ellipse);
        return Math.PI * (a + b);
    }

    public double calculateArea(Ellipse ellipse) {
        double a = getHalfWidth(ellipse);
        double b = getHalfHeight(ellipse);
        return Math.PI * a * b;
    }

    public boolean isCircle(Ellipse ellipse) {
        double a = getHalfWidth(ellipse);
        double b = getHalfHeight(ellipse);
        return a == b;
    }

    public boolean isCrossOX(Ellipse ellipse) {
        double lowY = ellipse.getStartPoint().getY();
        double highY = ellipse.getEndPoint().getY();
        return lowY <= 0 && highY >= 0;
    }

    public boolean isCrossOY(Ellipse ellipse) {
        double leftX = ellipse.getStartPoint().getX();
        double rightX = ellipse.getEndPoint().getX();
        return leftX <= 0 && rightX >= 0;
    }

    private double getHalfWidth(Ellipse ellipse) {
        return (ellipse.getEndPoint().getX() - ellipse.getStartPoint().getX()) / 2;
    }

    private double getHalfHeight(Ellipse ellipse) {
        return (ellipse.getEndPoint().getY() - ellipse.getStartPoint().getY()) / 2;
    }
}
