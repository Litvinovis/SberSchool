package com.zoo.exception;

public class AgeException extends Exception {
    public AgeException(String message) { super("Age exception: " + message); }
}
