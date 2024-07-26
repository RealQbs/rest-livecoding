package com.example.restlivecoding.adapters.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restlivecoding.domain.models.Item;
import com.example.restlivecoding.domain.ports.in.contract.NewItemAppearedHandler;
import com.example.restlivecoding.domain.ports.in.contract.NewItemAppearedHandler.NewItemAppearedEvent;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final NewItemAppearedHandler newItemAppearedHandler;
    private final CreateItemDtoMapper mapper;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody CreateItemRequest createItemRequest) {
        NewItemAppearedEvent newItemAppearedEvent = mapper.map(createItemRequest);
        Item item = newItemAppearedHandler.handle(newItemAppearedEvent);
        return ResponseEntity.created(getLocation(item)).build();
    }

    private URI getLocation(Item item) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();
    }
}
