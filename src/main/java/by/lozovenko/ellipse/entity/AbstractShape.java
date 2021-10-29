package by.lozovenko.ellipse.entity;

import by.lozovenko.ellipse.util.IdGenerator;

public class AbstractShape {
    private final long ellipseId;

    public AbstractShape(){
        ellipseId = IdGenerator.generateId();
    }
    public AbstractShape(long ellipseId){
        this.ellipseId = ellipseId;
    }
    public long getEllipseId() {
        return ellipseId;
    }
}
