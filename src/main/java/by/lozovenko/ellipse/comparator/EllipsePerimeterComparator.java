package by.lozovenko.ellipse.comparator;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.warehouse.Warehouse;

import java.util.Comparator;

public class EllipsePerimeterComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        Warehouse warehouse = Warehouse.getInstance();
        long ellipseOneId = o1.getEllipseId();
        long ellipseTwoId = o2.getEllipseId();
        double perimeterEllipseOne = warehouse.getParametersById(ellipseOneId).getPerimeter();
        double perimeterEllipseTwo = warehouse.getParametersById(ellipseTwoId).getPerimeter();
        return Double.compare(perimeterEllipseOne, perimeterEllipseTwo);
    }
}
