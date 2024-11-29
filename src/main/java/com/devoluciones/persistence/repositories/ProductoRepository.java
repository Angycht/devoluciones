package com.devoluciones.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.Productos;

public interface ProductoRepository extends ListCrudRepository<Productos, Integer> {

}
