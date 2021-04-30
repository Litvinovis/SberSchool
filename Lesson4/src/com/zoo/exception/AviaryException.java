package com.zoo.exception;

public class AviaryException extends Exception {
    public AviaryException(String message) {
        super("AviaryException: " + message);
    }
}
