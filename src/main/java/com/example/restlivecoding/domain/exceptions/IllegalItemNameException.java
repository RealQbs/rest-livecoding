package com.example.restlivecoding.domain.exceptions;

public class IllegalItemNameException extends RuntimeException {
    public IllegalItemNameException(String name) {
        super("Illegal item name: " + name);
    }
}
