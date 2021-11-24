package com.company.yavlash.repository;

import com.company.yavlash.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TriangleRepository {
    private static final Logger logger = LogManager.getLogger();
    private static TriangleRepository instance;
    private List<Triangle> triangles;

    public static TriangleRepository getInstance() {
        if (instance == null) {
            logger.log(Level.INFO, "creating singleton repository");
            instance = new TriangleRepository();
        }
        return instance;
    }

    private TriangleRepository() {
        triangles = new ArrayList<>();
    }

    public List<Triangle> getTriangles() {
        return new ArrayList<>(triangles);
    }

    public boolean add(Triangle triangle) {
        logger.log(Level.INFO, "Cone {} was added to Repository", triangle);
        return triangles.add(triangle);
    }

    public boolean addAll(Collection<? extends Triangle> t) {
        return triangles.addAll(t);
    }

    public boolean remove(Triangle element) {
        return triangles.remove(element);
    }

    public boolean removeAll(Collection<Triangle> t) {
        return triangles.removeAll(t);
    }

    public Optional<Triangle> get(int index) {
        Triangle triangle = triangles.get(index);
        return triangle == null ? Optional.empty() : Optional.of(triangle);
    }

    public Triangle set(int index, Triangle element) {
        return triangles.set(index, element);
    }

    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (specification.specify(triangle)) {
                result.add(triangle);
            }
        }
        return result;
    }

    public List<Triangle> queryStream(TriangleSpecification specification) {
        return triangles.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        return triangles.stream().sorted(comparator).collect(Collectors.toList());
    }
}