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
        double a = getWidth(ellipse);
        double b = getHeight(ellipse);
        double minorAxis = Math.min(a, b);
        double majorAxis = Math.max(a, b);
        return Math.sqrt(1 - Math.pow(majorAxis, 2) / Math.pow(minorAxis, 2));
    }

    public double calculatePerimeter(Ellipse ellipse) {
        double a = getWidth(ellipse);
        double b = getHeight(ellipse);
        return Math.PI * (a / 2 + b / 2);
    }

    public double calculateArea(Ellipse ellipse) {
        double a = getWidth(ellipse);
        double b = getHeight(ellipse);
        return Math.PI * a * b;
    }

    public boolean isCircle(Ellipse ellipse) {
        double a = getWidth(ellipse);
        double b = getHeight(ellipse);
        return a == b;
    }

    public boolean isCrossOX(Ellipse ellipse) {
        double lowX = ellipse.getStartPoint().getX();
        double highX = ellipse.getEndPoint().getX();
        return lowX <= 0 && highX >= 0;
    }

    public boolean isCrossOY(Ellipse ellipse) {
        double leftY = ellipse.getStartPoint().getY();
        double rightY = ellipse.getEndPoint().getY();
        return leftY <= 0 && rightY >= 0;
    }

    private double getWidth(Ellipse ellipse) {
        return (ellipse.getEndPoint().getX() - ellipse.getStartPoint().getX()) / 2;
    }

    private double getHeight(Ellipse ellipse) {
        return (ellipse.getEndPoint().getY() - ellipse.getStartPoint().getY()) / 2;
    }
}
