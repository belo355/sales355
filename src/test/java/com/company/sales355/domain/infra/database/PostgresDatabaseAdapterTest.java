package com.company.sales355.domain.infra.database;

import com.company.sales355.infra.database.PostgresDatabaseAdapter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PostgresDatabaseAdapterTest {

    @Test
    public void shouldBeFindIntoDbPostgres(){
        PostgresDatabaseAdapter postgresDatabaseAdapter = new PostgresDatabaseAdapter();
        List<Object> itemList = postgresDatabaseAdapter.findAll();
        Assert.assertNull(itemList);
    }
}
