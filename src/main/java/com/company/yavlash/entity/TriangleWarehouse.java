package com.company.yavlash.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleWarehouse {
    private static final Logger logger = LogManager.getLogger();
    private static TriangleWarehouse instance;
    private final Map<Long, TriangleParameters> map = new HashMap<>();;

    public static TriangleWarehouse getInstance() {
        if (instance == null) {
            logger.log(Level.INFO, "Creating singleton warehouse");
            instance = new TriangleWarehouse();
        }
        return instance;
    }

    private TriangleWarehouse() {

    }

    public TriangleParameters get(Long id){
        return map.getOrDefault(id, null);
    }

    public TriangleParameters put(Long id, TriangleParameters parameters) {
        return map.put(id, parameters);
    }

    public TriangleParameters remove(Long id) {
        return map.remove(id);
    }
}