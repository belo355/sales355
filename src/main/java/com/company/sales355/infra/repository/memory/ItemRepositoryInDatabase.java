package com.company.sales355.infra.repository.memory;

import com.company.sales355.domain.entity.Item;
import com.company.sales355.domain.repository.ItemRepository;
import com.company.sales355.infra.database.Database;

import java.util.Optional;

public class ItemRepositoryInDatabase implements ItemRepository {

    private final Database database;

    public ItemRepositoryInDatabase(Database database){
        this.database = database;
    }

    @Override
    public Optional<Item> findById(String id) {
        return database.findByIdOrCode(id);
    }
}
