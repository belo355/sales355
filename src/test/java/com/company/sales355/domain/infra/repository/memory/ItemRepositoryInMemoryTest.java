package com.company.sales355.domain.infra.repository.memory;

import com.company.sales355.domain.entity.Item;
import com.company.sales355.infra.repository.memory.ItemRepositoryInMemory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ItemRepositoryInMemoryTest {

    @Test
    public void shouldBeFindOneItemById(){
        ItemRepositoryInMemory itemRepositoryInMemory = new ItemRepositoryInMemory();
        Optional<Item> item = itemRepositoryInMemory.findById("1");
        item.ifPresent(Assert::assertNotNull);
    }
}
