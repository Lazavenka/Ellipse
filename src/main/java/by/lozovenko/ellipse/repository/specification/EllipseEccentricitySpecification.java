package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseEccentricitySpecification implements EllipseSpecification {
    private final double fromEccentricity;
    private final double toEccentricity;

    public EllipseEccentricitySpecification(double fromEccentricity, double toEccentricity) {
        this.fromEccentricity = Math.min(fromEccentricity, toEccentricity);
        this.toEccentricity = Math.max(fromEccentricity, toEccentricity);
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        EllipseAction ellipseAction = EllipseAction.getInstance();
        double eccentricity = ellipseAction.calculateEccentricity(ellipse);
        return eccentricity >= fromEccentricity && eccentricity <= toEccentricity;
    }
}
