package com.example.restlivecoding.domain.ports.out;

import com.example.restlivecoding.domain.models.Item;

public interface ItemRepository {

    public Item save(Item item);
}
