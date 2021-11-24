package com.company.yavlash.observer.impl;

import com.company.yavlash.entity.Triangle;
import com.company.yavlash.entity.TriangleParameters;
import com.company.yavlash.entity.TriangleWarehouse;
import com.company.yavlash.exception.TriangleException;
import com.company.yavlash.observer.Observer;
import com.company.yavlash.observer.TriangleEvent;
import com.company.yavlash.service.TriangleService;
import com.company.yavlash.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void parametersChange(TriangleEvent event) {
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        TriangleService triangleService = new TriangleServiceImpl();
        Triangle triangle = event.getSource();
        try {
            double perimeter = triangleService.findPerimeter(triangle);
            double area = triangleService.findSquare(triangle);
            TriangleParameters triangleParameters = new TriangleParameters(perimeter, area);
            triangleWarehouse.put(triangle.getTriangleId(), triangleParameters);
            logger.log(Level.INFO, "Parameters of the triangle #{} were updated", triangle.getTriangleId());
        } catch (TriangleException e) {
            logger.log(Level.WARN, "Exception {} in parametersChange method!", e.getMessage());
        }
    }
}