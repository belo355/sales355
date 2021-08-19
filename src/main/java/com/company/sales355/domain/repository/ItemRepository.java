package com.company.sales355.domain.repository;

import com.company.sales355.domain.entity.Item;

import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findById(String id);
}
