package by.lozovenko.ellipse.entity;

import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.observer.EllipseEvent;
import by.lozovenko.ellipse.observer.Observable;
import by.lozovenko.ellipse.observer.Observer;
import by.lozovenko.ellipse.util.EllipsePointSwitcher;
import by.lozovenko.ellipse.validator.EllipseValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends AbstractShape implements Observable {
    private static final Logger LOGGER = LogManager.getLogger();
    private Point2D startPoint;
    private Point2D endPoint;
    private final List<Observer> observers;

    public Ellipse(Point2D startPoint, Point2D endPoint) {
        observers = new ArrayList<>();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Ellipse(Point2D startPoint, Point2D endPoint, long ellipseId) {
        super(ellipseId);
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

    public void setStartPoint(Point2D newStartPoint) throws ProjectException {
        EllipseValidator validator = new EllipseValidator();
        if (!validator.isValid(newStartPoint, this.endPoint)) {
            throw new ProjectException("Incorrect point coordinates. Cannot create rectangle.");
        }
        if (EllipsePointSwitcher.isNeedSwitchPoints(newStartPoint, this.endPoint)) {
            EllipsePointSwitcher.switchPoints(newStartPoint, this.endPoint);
            LOGGER.debug("Points switched");
        }
        this.startPoint = newStartPoint;
        notifyObservers();
    }

    public void setStartPoint(double x, double y) throws ProjectException {
        Point2D newStartPoint = new Point2D(x, y);
        setStartPoint(newStartPoint);
    }

    public void setEndPoint(Point2D newEndPoint) throws ProjectException {
        EllipseValidator validator = new EllipseValidator();
        if (!validator.isValid(newEndPoint, this.startPoint)) {
            throw new ProjectException("Incorrect point coordinates. Points not creates rectangle.");
        }
        if (EllipsePointSwitcher.isNeedSwitchPoints(this.startPoint, newEndPoint)) {
            EllipsePointSwitcher.switchPoints(this.startPoint, newEndPoint);
            LOGGER.debug("Points switched");
        }
        this.endPoint = newEndPoint;
        notifyObservers();
    }

    public void setEndPoint(double x, double y) throws ProjectException {
        Point2D newEndPoint = new Point2D(x, y);
        setEndPoint(newEndPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) o;

        return getEllipseId() == ellipse.getEllipseId() &&
                startPoint.equals(ellipse.startPoint) &&
                endPoint.equals(ellipse.endPoint);
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
        if (observers.isEmpty()) {
            return;
        }
        EllipseEvent event = new EllipseEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
        LOGGER.debug("Parameters changed.");
    }
}
