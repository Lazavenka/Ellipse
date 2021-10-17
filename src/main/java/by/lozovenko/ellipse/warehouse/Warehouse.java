package by.lozovenko.ellipse.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Long, EllipseParameter> data;

    private Warehouse(){
        data = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public void updateEllipseParameters(long ellipseId, double perimeter, double area){
        EllipseParameter ellipseParameter = data.get(ellipseId);
        ellipseParameter.setPerimeter(perimeter);
        ellipseParameter.setArea(area); //TODO чето сделать еще тут...
    }
}
