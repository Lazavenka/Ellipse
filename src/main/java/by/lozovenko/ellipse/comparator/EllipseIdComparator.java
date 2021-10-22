package by.lozovenko.ellipse.comparator;

import by.lozovenko.ellipse.entity.Ellipse;

import java.util.Comparator;

public class EllipseIdComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        return Long.compare(o1.getEllipseId(), o2.getEllipseId());
    }
}
