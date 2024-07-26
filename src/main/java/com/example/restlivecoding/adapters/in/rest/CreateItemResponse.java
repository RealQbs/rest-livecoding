package com.example.restlivecoding.adapters.in.rest;

import java.util.UUID;

public record CreateItemResponse(
        UUID id,
        String name,
        String description
) {
}
