package by.lozovenko.ellipse.action;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseActionTest {
    Ellipse ellipse;
    double calculationError = 1E-5;
    @BeforeClass
    public void setEllipse() throws ProjectException {
        double[] coordinates = {-1, -1, 1, 1.2};
        ellipse = EllipseFactory.createEllipse(coordinates);
    }
    @Test
    public void testCalculateEccentricity() {
        double expected = Math.sqrt(1 - Math.pow(1, 2) / Math.pow(1.1, 2));
        double actual = EllipseAction.getInstance().calculateEccentricity(ellipse);

        assertEquals(actual, expected, calculationError);
    }

    @Test
    public void testCalculatePerimeter() {
        double expected = Math.PI * (1 + 1.1);
        double actual = EllipseAction.getInstance().calculatePerimeter(ellipse);

        assertEquals(actual, expected, calculationError);
    }

    @Test
    public void testCalculateArea() {
        double expected = Math.PI * 1 * 1.1;
        double actual = EllipseAction.getInstance().calculateArea(ellipse);

        assertEquals(actual, expected, calculationError);
    }

    @Test
    public void testIsCircleNegative() {
        boolean actual = EllipseAction.getInstance().isCircle(ellipse);

        assertFalse(actual);
    }

    @Test
    public void testIsCrossOX() {
        boolean actual = EllipseAction.getInstance().isCrossOX(ellipse);

        assertTrue(actual);
    }

    @Test
    public void testIsCrossOY() {
        boolean actual = EllipseAction.getInstance().isCrossOY(ellipse);

        assertTrue(actual);
    }
}