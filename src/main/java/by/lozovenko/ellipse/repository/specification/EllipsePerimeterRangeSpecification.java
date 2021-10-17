package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipsePerimeterRangeSpecification implements EllipseSpecification {
    private final double minPerimeterValue;
    private final double maxPerimeterValue;
    public EllipsePerimeterRangeSpecification(double minPerimeterValue, double maxPerimeterValue){
        this.minPerimeterValue = Math.min(minPerimeterValue, maxPerimeterValue);
        this.maxPerimeterValue = Math.max(minPerimeterValue, maxPerimeterValue);
    }
    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseAction action = EllipseAction.getInstance();
        double perimeter = action.calculatePerimeter(ellipse);
        return perimeter >= minPerimeterValue && perimeter <= maxPerimeterValue;
    }
}
