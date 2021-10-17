package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseAreaRangeSpecification implements EllipseSpecification {
    private final double minAreaValue;
    private final double maxAreaValue;
    public EllipseAreaRangeSpecification(double minAreaValue, double maxAreaValue){
        this.minAreaValue = Math.min(minAreaValue, maxAreaValue);
        this.maxAreaValue = Math.max(minAreaValue, maxAreaValue);
    }
    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseAction action = EllipseAction.getInstance();
        double perimeter = action.calculateArea(ellipse);
        return perimeter >= minAreaValue && perimeter <= maxAreaValue;
    }
}
