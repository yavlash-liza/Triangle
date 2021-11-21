package com.company.yavlash.exception;

public class TriangleNotExistException extends Exception{
    public TriangleNotExistException() {
    }

    public TriangleNotExistException(String message) {
        super(message);
    }

    public TriangleNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNotExistException(Throwable cause) {
        super(cause);
    }
}