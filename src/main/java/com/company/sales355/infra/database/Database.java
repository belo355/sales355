package com.company.sales355.infra.database;

import java.util.List;

public interface Database  {

    <T> List<T> findAll();

    <T> T findByIdOrCode(String id);
}
