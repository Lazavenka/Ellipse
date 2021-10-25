package by.lozovenko.ellipse.repository;

import by.lozovenko.ellipse.comparator.EllipseAreaComparator;
import by.lozovenko.ellipse.comparator.EllipsePerimeterComparator;
import by.lozovenko.ellipse.entity.Ellipse;
import by.lozovenko.ellipse.exception.ProjectException;
import by.lozovenko.ellipse.factory.EllipseFactory;
import by.lozovenko.ellipse.observer.impl.EllipseObserver;
import by.lozovenko.ellipse.repository.specification.EllipseAreaRangeSpecification;
import by.lozovenko.ellipse.repository.specification.EllipseIdRangeSpecification;
import by.lozovenko.ellipse.repository.specification.EllipseIdSpecification;
import by.lozovenko.ellipse.warehouse.Warehouse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EllipseRepositoryTest {
    private final List<Ellipse> ellipses = new ArrayList<>();
    private final double[][] dataCoordinates = {
            {-1.2, 2.2, 4.5, 2.3},  // s = 0.45,    p = 4.55
            {1, 2, 4, 7},           // s = 11.78,   p = 6.28
            {2, 2, 4, 4},           // s = 3.1415,  p = 3.1415
            {-4, -4, -2, -2.1},     // s = 2.9845,  p = 3.063
            {0.2, 0.5, 0.4, 0.6},   // s = 0.015,   p = 0.23
            {2, 4, 14, 15},         // s = 103.67,  p = 18.06
            {0, 0, 2, 3},           // s = 4.7123,  p = 3.927
            {-1, -1, 1, 1.2},       // s = 3.4557,  p = 3.2986
            {-4, -3, -3, -2},       // s = 0.785,   p = 1.57
            {10, 4, 8, 1.1},        // s = 4.555,   p = 3.848
            {0, 0.1, 0.2, -0.1},    // s = 0.0314,  p = 0.314
    };

    @BeforeClass
    public void setUp() throws ProjectException {
        EllipseObserver observer = new EllipseObserver();
        for (double[] coordinates : dataCoordinates) {
            Ellipse ellipse = EllipseFactory.createEllipse(coordinates);
            ellipse.attach(observer);
            ellipses.add(ellipse);
            Warehouse.getInstance().putParameters(ellipse);
            EllipseRepository.getInstance().add(ellipse);
        }
    }

    @Test
    public void testQueryById() {
        final int listIndex = 5;
        final long id = ellipses.get(listIndex).getEllipseId();
        List<Ellipse> expected = List.of(ellipses.get(listIndex));
        List<Ellipse> actual = EllipseRepository.getInstance().query(new EllipseIdSpecification(id));
        System.out.println(EllipseRepository.getInstance().getEllipses());
        System.out.println(Warehouse.getInstance().getEllipseMap());
        System.out.println(ellipses);
        assertEquals(actual, expected);
    }

    @Test
    public void testQueryByIdRange() {
        final int listStartIndex = 4;
        final int listEndIndex = 7;
        final long startId = ellipses.get(listStartIndex).getEllipseId();
        final long endId = ellipses.get(listEndIndex).getEllipseId();
        List<Ellipse> expected = List.of(ellipses.get(4), ellipses.get(5), ellipses.get(6), ellipses.get(7));
        List<Ellipse> actual = EllipseRepository.getInstance().query(new EllipseIdRangeSpecification(startId, endId));

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryByAreaRange() {
        final int fromArea = 0;
        final int toArea = 1;
        List<Ellipse> expected = List.of(ellipses.get(0), ellipses.get(4), ellipses.get(8), ellipses.get(10));
        List<Ellipse> actual = EllipseRepository.getInstance().query(new EllipseAreaRangeSpecification(fromArea, toArea));

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryStreamById() {
        final int listIndex = 7;
        final long id = ellipses.get(listIndex).getEllipseId();
        List<Ellipse> expected = List.of(ellipses.get(listIndex));
        List<Ellipse> actual = EllipseRepository.getInstance().queryStream(new EllipseIdSpecification(id));

        assertEquals(actual, expected);
    }

    @Test
    public void testSortByArea() {
        List<Ellipse> expected = List.of(ellipses.get(4), ellipses.get(10), ellipses.get(0),
                ellipses.get(8), ellipses.get(3), ellipses.get(2), ellipses.get(7),
                ellipses.get(9), ellipses.get(6), ellipses.get(1), ellipses.get(5));
        List<Ellipse> actual = EllipseRepository.getInstance().sort(new EllipseAreaComparator());

        assertEquals(actual, expected);
    }

    @Test
    public void testSortByPerimeter() {
        List<Ellipse> expected = List.of(ellipses.get(4), ellipses.get(10), ellipses.get(8),
                ellipses.get(3), ellipses.get(2), ellipses.get(7), ellipses.get(9),
                ellipses.get(6), ellipses.get(0), ellipses.get(1), ellipses.get(5));
        List<Ellipse> actual = EllipseRepository.getInstance().sort(new EllipsePerimeterComparator());

        assertEquals(actual, expected);
    }
}