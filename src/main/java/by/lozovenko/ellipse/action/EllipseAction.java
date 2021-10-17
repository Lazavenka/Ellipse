package by.lozovenko.ellipse.action;

import by.lozovenko.ellipse.entity.Ellipse;

public class EllipseAction {
    private static EllipseAction INSTANCE;
    private EllipseAction(){
    }
    public static EllipseAction getInstance() {
        if (INSTANCE==null){
            INSTANCE = new EllipseAction();
        }
        return INSTANCE;
    }
    public double calculatePerimeter(Ellipse ellipse){
        return 0; //TODO IMPLEMENT
    }
    public double calculateArea(Ellipse ellipse){
        return 0; //TODO IMPLEMENT
    }
}
