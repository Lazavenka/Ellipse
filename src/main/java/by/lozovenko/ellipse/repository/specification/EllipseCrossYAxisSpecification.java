package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseCrossYAxisSpecification implements EllipseSpecification {
    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseAction ellipseAction = EllipseAction.getInstance();
        return ellipseAction.isCrossOY(ellipse);
    }
}
