package by.lozovenko.ellipse.factory;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.entity.Point2D;
import by.lozovenko.ellipse.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseFactoryTest {
    Ellipse expectedEllipse;

    @BeforeClass
    public void setUpExpectedEllipse() {
        expectedEllipse = new Ellipse(new Point2D(1.2, 2.2),
                new Point2D(3.3, 4));
    }

    @Test()
    public void testCreateEllipseCorrectDoubleArray() throws ProjectException {
        double[] coordinates = {1.2, 2.2, 3.3, 4};
        Ellipse actual = EllipseFactory.createEllipse(coordinates);

        assertEquals(actual, expectedEllipse);
    }

    @Test()
    public void testCreateEllipseCorrectString() throws ProjectException {
        String coordinates = "1.2 2.2 3.3 4";
        Ellipse actual = EllipseFactory.createEllipse(coordinates);

        assertEquals(actual, expectedEllipse);
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateEllipseIncorrectDoubleArray() throws ProjectException {
        double[] coordinates = {1.2, 2.2, 3.3};
        EllipseFactory.createEllipse(coordinates);
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateEllipseIncorrectDoubleArrayTwo() throws ProjectException {
        double[] coordinates = {1.2, 2.2, 1.2, 5};
        EllipseFactory.createEllipse(coordinates);
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateEllipseIncorrectString() throws ProjectException {
        String coordinates = "1.2 2.2 3.f3 4 5 -2.2";
        EllipseFactory.createEllipse(coordinates);
    }
}