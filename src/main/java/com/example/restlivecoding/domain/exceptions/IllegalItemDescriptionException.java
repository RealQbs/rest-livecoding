package com.example.restlivecoding.domain.exceptions;

public class IllegalItemDescriptionException extends RuntimeException {
    public IllegalItemDescriptionException(String description) {
        super("Illegal item description: " + description);
    }
}
