package com.company.sales355.userCase;

import com.company.sales355.entity.Item;

import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findById(String id);
}
