package com.example.restlivecoding.integration.db;

import com.example.restlivecoding.domain.models.Item;
import com.example.restlivecoding.domain.ports.out.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ItemInMemoryRepository implements ItemRepository {

    private final Map<UUID, Item> itemsDb = new HashMap<>();

    @Override
    public Item save(Item item) {
        return itemsDb.put(item.getId(), item);
    }
}
