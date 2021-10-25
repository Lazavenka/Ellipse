package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseIdSpecification implements EllipseSpecification {
    private final long ellipseId;

    public EllipseIdSpecification(long ellipseId) {
        this.ellipseId = ellipseId;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() == ellipseId;
    }
}
