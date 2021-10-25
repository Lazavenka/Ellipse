package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.entity.Point2D;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import by.lozovenko.ellipse.repository.EllipseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseAreaRangeSpecificationTest {
    EllipseSpecification specification;
    Ellipse largeEllipse;
    Ellipse smallEllipse;

    @BeforeClass
    public void setUp() throws ProjectException {
        specification = new EllipseAreaRangeSpecification(1, 2);
        largeEllipse = EllipseFactory.createEllipse(new Point2D(1, 1),
                new Point2D(20, 20));   // area ~283,52
        smallEllipse = EllipseFactory.createEllipse(new Point2D(1, 1),
                new Point2D(3, 2));     // area ~1,57
    }
    @Test
    public void testSpecifyPositiveScenario(){
        boolean expected = specification.specify(smallEllipse);

        assertTrue(expected);
    }

    @Test
    public void testSpecifyNegativeScenario(){
        boolean expected = specification.specify(largeEllipse);

        assertFalse(expected);
    }
}