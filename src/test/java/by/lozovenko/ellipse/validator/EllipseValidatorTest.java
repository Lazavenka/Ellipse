package by.lozovenko.ellipse.validator;

import by.lozovenko.ellipse.entity.Point2D;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseValidatorTest {
    EllipseValidator ellipseValidator = new EllipseValidator();

    @Test(description = "Valid data set.")
    public void testIsValid() {
        double[] coordinates = new double[]{1.2, 2.2, 4.4, 5.5};
        boolean actual = ellipseValidator.isValid(coordinates);

        assertTrue(actual);
    }

    @Test(description = "Not enough numbers in set.")
    public void testIsValidThreeNumbers() {
        double[] coordinates = new double[]{1.2, 2.2, 4.4};
        boolean actual = ellipseValidator.isValid(coordinates);

        assertFalse(actual);
    }

    @Test(description = "X coordinates in one axis.")
    public void testIsValidDataOnXAxis() {
        double[] coordinates = new double[]{1.2, 2.2, 1.2, 5.5};
        boolean actual = ellipseValidator.isValid(coordinates);

        assertFalse(actual);
    }

    @Test(description = "Y coordinates in one axis.")
    public void testIsValidDataOnYAxis() {
        double[] coordinates = new double[]{1.2, 2.2, -2.2, 2.2};
        boolean actual = ellipseValidator.isValid(coordinates);

        assertFalse(actual);
    }

    @Test(description = "Points validation")
    public void testIsValidPoints() {
        Point2D startPoint = new Point2D(1.2, 2.2);
        Point2D endPoint = new Point2D(3.2, 2.2);
        boolean actual = ellipseValidator.isValid(startPoint, endPoint);

        assertFalse(actual);
    }
}