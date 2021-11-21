package com.company.yavlash.exception;

public class InvalidMethodParameterException extends Exception{
    public InvalidMethodParameterException() {
    }

    public InvalidMethodParameterException(String message) {
        super(message);
    }

    public InvalidMethodParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMethodParameterException(Throwable cause) {
        super(cause);
    }
}