package com.example.restlivecoding.domain.ports.in.contract;

import com.example.restlivecoding.domain.models.Item;

public interface NewItemAppearedHandler {

    Item handle(NewItemAppearedEvent newItemAppearedEvent);

    public record NewItemAppearedEvent(String name, String description) {
    }
}
