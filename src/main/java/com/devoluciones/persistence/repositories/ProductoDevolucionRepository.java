package com.devoluciones.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.ProductoDevolucion;

public interface ProductoDevolucionRepository extends ListCrudRepository<ProductoDevolucion, Integer>{
	List<ProductoDevolucion> findByIdProducto(int idProducto);
}
