package by.lozovenko.ellipse.warehouse;

public class EllipseParameter {
    private double perimeter;
    private double area;

    public EllipseParameter() {
    }

    public EllipseParameter(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseParameter{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", area=").append(area);
        sb.append('}');
        return sb.toString();
    }
}
