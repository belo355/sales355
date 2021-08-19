package com.company.sales355.infra.repository.memory;

import com.company.sales355.domain.entity.Item;
import com.company.sales355.domain.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepositoryInMemory implements ItemRepository {

    private List<Item> items = new ArrayList<>();
    public ItemRepositoryInMemory(){
        items.add(new Item("1", "Guitarra", new BigDecimal("1000"),  100, 50, 15, 3));
        items.add(new Item("2", "Amplificador", new BigDecimal("5000"),  50, 50, 50, 22));
        items.add(new Item("3", "Cabo", new BigDecimal("30"), 10 , 10 , 10, 1));
    }

    @Override
    public Optional<Item> findById(String id) {
        return this.items.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
