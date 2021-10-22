package by.lozovenko.ellipse.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger LOGGER = LogManager.getLogger();
    private static Warehouse instance;
    private final Map<Long, EllipseParameter> ellipseMap;

    private Warehouse() {
        ellipseMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long ellipseId, double perimeter, double area) {
        EllipseParameter ellipseParameter = new EllipseParameter();
        ellipseParameter.setArea(area);
        ellipseParameter.setPerimeter(perimeter);
        putParameters(ellipseId, ellipseParameter);

    }

    public void putParameters(long ellipseId, EllipseParameter ellipseParameter) {
        ellipseMap.put(ellipseId, ellipseParameter);
    }

    public EllipseParameter getParametersById(long ellipseId) {
        return ellipseMap.get(ellipseId);
    }

    public void updateEllipseParameters(long ellipseId, double perimeter, double area) {
        EllipseParameter ellipseParameter = getParametersById(ellipseId);
        if (ellipseParameter != null) {
            ellipseParameter.setPerimeter(perimeter);
            ellipseParameter.setArea(area);
        } else {
            LOGGER.debug("Ellipse with id {} not found!", ellipseId);
        }
    }

    public Map<Long, EllipseParameter> getEllipseMap() {
        return Map.copyOf(ellipseMap);
    }

}
