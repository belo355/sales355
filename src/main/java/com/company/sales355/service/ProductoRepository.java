package com.company.sales355.service;

import com.company.sales355.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
}
