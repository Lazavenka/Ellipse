package by.lozovenko.ellipse.util;

import by.lozovenko.ellipse.entity.Point2D;

public class EllipsePointSwitcher {
    private EllipsePointSwitcher() {
    }

    public static void switchPoints(Point2D pointOne, Point2D pointTwo) {
        double leftLowX = Math.min(pointOne.getX(), pointTwo.getX());
        double leftLowY = Math.min(pointOne.getY(), pointTwo.getY());
        double rightUpX = Math.max(pointOne.getX(), pointTwo.getX());
        double rightUpY = Math.max(pointOne.getY(), pointTwo.getY());
        pointOne.setX(leftLowX);
        pointOne.setY(leftLowY);
        pointTwo.setX(rightUpX);
        pointTwo.setY(rightUpY);
    }

    public static boolean isNeedSwitchPoints(Point2D startPoint, Point2D endPoint) {
        return startPoint.getX() >= endPoint.getX() || startPoint.getY() >= endPoint.getY();

    }
}
