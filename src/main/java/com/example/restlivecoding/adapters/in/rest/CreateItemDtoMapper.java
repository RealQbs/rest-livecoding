package com.example.restlivecoding.adapters.in.rest;

import com.example.restlivecoding.domain.models.Item;
import com.example.restlivecoding.domain.ports.in.contract.NewItemAppearedHandler.NewItemAppearedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateItemDtoMapper {

    NewItemAppearedEvent map(CreateItemRequest createItemRequest);

    CreateItemResponse map(Item item);
}
