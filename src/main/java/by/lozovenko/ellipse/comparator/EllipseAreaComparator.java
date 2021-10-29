package by.lozovenko.ellipse.comparator;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.warehouse.Warehouse;

import java.util.Comparator;

public class EllipseAreaComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        Warehouse warehouse = Warehouse.getInstance();
        long ellipseOneId = o1.getEllipseId();
        long ellipseTwoId = o2.getEllipseId();
        double areaEllipseOne = warehouse.getParametersById(ellipseOneId).getArea();
        double areaEllipseTwo = warehouse.getParametersById(ellipseTwoId).getArea();
        return Double.compare(areaEllipseOne, areaEllipseTwo);
    }
}
