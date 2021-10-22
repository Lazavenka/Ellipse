package by.lozovenko.ellipse.comparator;

import by.lozovenko.ellipse.entity.Ellipse;

import java.util.Comparator;

public class EllipseStartPointYComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        double yEllipseOne = o1.getStartPoint().getY();
        double yEllipseTwo = o2.getStartPoint().getY();
        return Double.compare(yEllipseOne, yEllipseTwo);
    }
}
