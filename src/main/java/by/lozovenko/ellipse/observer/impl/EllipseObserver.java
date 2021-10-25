package by.lozovenko.ellipse.observer.impl;

import by.lozovenko.ellipse.action.EllipseAction;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.observer.EllipseEvent;
import by.lozovenko.ellipse.observer.Observer;
import by.lozovenko.ellipse.warehouse.Warehouse;

public class EllipseObserver implements Observer {
    @Override
    public void parameterChanged(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        EllipseAction ellipseAction = EllipseAction.getInstance();
        double newArea = ellipseAction.calculateArea(ellipse);
        double newPerimeter = ellipseAction.calculatePerimeter(ellipse);
        Warehouse warehouse = Warehouse.getInstance();
        long ellipseId = ellipse.getEllipseId();
        warehouse.updateEllipseParameters(ellipseId, newPerimeter, newArea);
    }
}
