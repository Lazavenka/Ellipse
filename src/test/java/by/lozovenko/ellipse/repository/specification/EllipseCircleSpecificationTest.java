package by.lozovenko.ellipse.repository.specification;

import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.entity.Point2D;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import by.lozovenko.ellipse.repository.EllipseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EllipseCircleSpecificationTest {
    EllipseSpecification specification;
    Ellipse ellipseOne;
    Ellipse ellipseTwo;

    @BeforeClass
    public void setUp() throws ProjectException {
        specification = new EllipseCircleSpecification();
        ellipseOne = EllipseFactory.createEllipse(new Point2D(1, 1),
                new Point2D(2, 2));     // circle
        ellipseTwo = EllipseFactory.createEllipse(new Point2D(1, 1),
                new Point2D(2, 3));     // ellipse
    }
    @Test
    public void testSpecifyPositiveScenario() {
        boolean expected = specification.specify(ellipseOne);

        assertTrue(expected);
    }

    @Test
    public void testSpecifyNegativeScenario(){
        boolean expected = specification.specify(ellipseTwo);

        assertFalse(expected);
    }
}