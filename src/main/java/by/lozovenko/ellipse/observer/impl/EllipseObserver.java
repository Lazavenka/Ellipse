package by.lozovenko.ellipse.observer.impl;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.entity.Point2D;
import by.lozovenko.ellipse.observer.EllipseEvent;
import by.lozovenko.ellipse.observer.Observer;
import by.lozovenko.ellipse.warehouse.Warehouse;

public class EllipseObserver implements Observer{
    @Override
    public void parameterChanged(EllipseEvent event) {
        Ellipse ellipse = event.getSource();
        Warehouse warehouse = Warehouse.getInstance();
        long ellipseId = ellipse.getEllipseId();

    }
}
