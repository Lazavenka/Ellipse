package by.lozovenko.ellipse.entity;

import by.lozovenko.ellipse.util.IdGenerator;

public class AbstractShape {
    private final long ellipseId;

    {
        ellipseId = IdGenerator.generateId();
    }

    public long getEllipseId() {
        return ellipseId;
    }
}
