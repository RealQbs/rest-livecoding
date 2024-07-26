package com.example.restlivecoding.domain.services;

import com.example.restlivecoding.domain.exceptions.IllegalItemDescriptionException;
import com.example.restlivecoding.domain.exceptions.IllegalItemNameException;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessValidator {

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalItemNameException(name);
        }
    }

    public void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalItemDescriptionException(description);
        }
    }
}
