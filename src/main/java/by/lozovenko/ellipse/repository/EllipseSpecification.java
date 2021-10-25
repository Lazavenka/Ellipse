package by.lozovenko.ellipse.repository;

import by.lozovenko.ellipse.entity.Ellipse;

public interface EllipseSpecification {
    boolean specify(Ellipse ellipse);
}
