package by.lozovenko.ellipse.repository;

import by.lozovenko.ellipse.entity.Ellipse;

import java.util.*;

public class EllipseRepository {
    private static EllipseRepository instance;
    private final List<Ellipse> ellipses;

    private EllipseRepository() {
        ellipses = new ArrayList<>();
    }

    public static EllipseRepository getInstance() {
        if (instance == null) {
            instance = new EllipseRepository();
        }
        return instance;
    }

    public int size() {
        return ellipses.size();
    }

    public boolean isEmpty() {
        return ellipses.isEmpty();
    }

    public boolean add(Ellipse ellipse) {
        return ellipses.add(ellipse);
    }

    public Ellipse get(int index){
        return ellipses.get(index);
    }

    public boolean remove(Ellipse ellipse) {
        return ellipses.remove(ellipse);
    }

    public boolean addAll(Collection<? extends Ellipse> collection) {
        return ellipses.addAll(collection);
    }

    public List<Ellipse> getEllipses() {
        return Collections.unmodifiableList(ellipses);
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        List<Ellipse> query = new ArrayList<>();
        for (Ellipse ellipse : ellipses) {
            if (specification.specify(ellipse)) {
                query.add(ellipse);
            }
        }
        return query;
    }

    public List<Ellipse> queryStream(EllipseSpecification specification) {
        return ellipses.stream().filter(specification::specify).toList();
    }

    public List<Ellipse> sort(Comparator<Ellipse> comparator) {
        return ellipses.stream().sorted(comparator).toList();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseRepository{");
        sb.append("ellipses=").append(ellipses);
        sb.append('}');
        return sb.toString();
    }
}
