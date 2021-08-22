package com.company.sales355.infra.database;

import java.util.List;

public class PostgresDatabaseAdapter implements Database {
    @Override
    public <T> List<T> findAll() {
        //query para retorno de persistencia via postgres   
        return null;
    }

    @Override
    public <T> T findByIdOrCode(String id) {
        return null;
    }
}
