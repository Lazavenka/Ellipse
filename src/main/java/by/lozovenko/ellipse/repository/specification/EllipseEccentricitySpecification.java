package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseEccentricitySpecification implements EllipseSpecification {
    private double fromEccentricity;
    private double toEccentricity;

    public EllipseEccentricitySpecification(double fromEccentricity, double toEccentricity) {
        this.fromEccentricity = fromEccentricity;
        this.toEccentricity = toEccentricity;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseAction ellipseAction = EllipseAction.getInstance();
        double eccentricity = ellipseAction.calculateEccentricity(ellipse);
        return eccentricity >= fromEccentricity && eccentricity <= toEccentricity;
    }
}
