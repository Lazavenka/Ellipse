package by.lozovenko.ellipse.factory;

import by.lozovenko.ellipse.exception.ProjectException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseFactoryTest {

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateEllipseIncorrectDoubleArray() throws ProjectException {
        double[] coordinates = {1.2, 2.2, 3.3};
        EllipseFactory.createEllipse(coordinates);
    }
}