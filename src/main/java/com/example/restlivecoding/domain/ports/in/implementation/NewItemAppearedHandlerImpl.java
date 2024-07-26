package com.example.restlivecoding.domain.ports.in.implementation;

import com.example.restlivecoding.domain.models.Item;
import com.example.restlivecoding.domain.ports.in.contract.NewItemAppearedHandler;
import com.example.restlivecoding.domain.ports.out.ItemRepository;
import com.example.restlivecoding.domain.services.ItemBusinessValidator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewItemAppearedHandlerImpl implements NewItemAppearedHandler {

    ItemBusinessValidator itemBusinessValidator;

    ItemRepository itemRepository;

    @Override
    public Item handle(NewItemAppearedEvent newItemAppearedEvent) {
        validateEvent(newItemAppearedEvent);
        Item item = new Item(newItemAppearedEvent.name(), newItemAppearedEvent.description());
        return itemRepository.save(item);
    }

    private void validateEvent(NewItemAppearedEvent newItemAppearedEvent) {
        itemBusinessValidator.validateName(newItemAppearedEvent.name());
        itemBusinessValidator.validateDescription(newItemAppearedEvent.description());
    }
}
