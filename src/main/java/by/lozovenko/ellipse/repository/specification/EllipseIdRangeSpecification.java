package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.repository.EllipseSpecification;

public class EllipseIdRangeSpecification implements EllipseSpecification {
    private final long startId;
    private final long endId;

    public EllipseIdRangeSpecification(long startId, long endId) {
        this.startId = Math.min(startId, endId);
        this.endId = Math.max(startId, endId);
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() >= startId && ellipse.getEllipseId() <= endId;
    }
}
