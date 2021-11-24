package com.company.yavlash.util;

public class IdGenerator {
    private static Long id;
    static {
        id = 0L;
    }

    private IdGenerator() {
    }

    public static Long generateId() {
        return ++id;
    }
}