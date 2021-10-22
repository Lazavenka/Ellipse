package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseIdRangeSpecification implements EllipseSpecification {
    private long startId;
    private long endId;

    public EllipseIdRangeSpecification(long startId, long endId) {
        this.startId = startId;
        this.endId = endId;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() >= startId && ellipse.getEllipseId() <= endId;
    }
}
