package com.example.restlivecoding.domain.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Item {
    UUID id;
    String name;
    String description;

    public Item(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }
}
