package by.lozovenko.ellipse.entity;

import by.lozovenko.ellipse.observer.EllipseEvent;
import by.lozovenko.ellipse.observer.Observable;
import by.lozovenko.ellipse.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends AbstractShape implements Observable{

    private Point2D startPoint;
    private Point2D endPoint;
    private final List<Observer> observers;

    public Ellipse(Point2D startPoint, Point2D endPoint) {
        observers = new ArrayList<>();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }
    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
        notifyObservers();
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
        notifyObservers();
    }

    @Override
    public long getEllipseId() {
        return super.getEllipseId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Ellipse ellipse = (Ellipse) o;

        if (getEllipseId() != ellipse.getEllipseId()){
            return false;
        }
        if (!startPoint.equals(ellipse.startPoint)) {
            return false;
        }
        return endPoint.equals(ellipse.endPoint);
    }

    @Override
    public int hashCode() {
        int result = (int) (getEllipseId() ^ (getEllipseId() >>> 32));
        result = 31 * result + startPoint.hashCode();
        result = 31 * result + endPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append("={ellipseId=").append(getEllipseId());
        sb.append(", startPoint {").append(startPoint.toString());
        sb.append("}, endPoint {").append(endPoint.toString());
        sb.append("}}");
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (observers.isEmpty()){
            return;
        }
        EllipseEvent event = new EllipseEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
    }
}
