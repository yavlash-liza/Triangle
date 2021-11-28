package com.company.yavlash.repository;

import com.company.yavlash.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TriangleRepository {
    private static final Logger logger = LogManager.getLogger();
    private static TriangleRepository instance;
    private List<Triangle> triangles = new ArrayList<>();

    public static TriangleRepository getInstance() {
        if (instance == null) {
            logger.log(Level.INFO, "Repository was created");
            instance = new TriangleRepository();
        }
        return instance;
    }

    public List<Triangle> getTriangles() {
        return new ArrayList<>(triangles);
    }

    public boolean add(Triangle triangle) {
        logger.log(Level.INFO, "Triangle {} was added to repository", triangle);
        return triangles.add(triangle);
    }

    public boolean addAll(Collection<? extends Triangle> t) {
        return triangles.addAll(t);
    }

    public boolean remove(Triangle element) {
        return triangles.remove(element);
    }

    public boolean removeAll(Collection<Triangle> triangles) {
        return triangles.removeAll(triangles);
    }

    public Triangle get(int index) {
        return triangles.get(index);
    }

    public Triangle set(int index, Triangle element) {
        return triangles.set(index, element);
    }

    public List<Triangle> query(TriangleSpecification specification) {
        return triangles.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        return triangles.stream().sorted(comparator).collect(Collectors.toList());
    }
}