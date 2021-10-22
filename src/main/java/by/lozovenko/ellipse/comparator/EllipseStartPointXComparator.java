package by.lozovenko.ellipse.comparator;

import by.lozovenko.ellipse.entity.Ellipse;

import java.util.Comparator;

public class EllipseStartPointXComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        double xEllipseOne = o1.getStartPoint().getX();
        double xEllipseTwo = o2.getStartPoint().getX();
        return Double.compare(xEllipseOne, xEllipseTwo);
    }
}
