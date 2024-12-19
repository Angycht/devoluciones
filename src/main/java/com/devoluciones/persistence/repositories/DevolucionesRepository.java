package com.devoluciones.persistence.repositories;


import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.Devoluciones;

public interface DevolucionesRepository extends ListCrudRepository<Devoluciones, Integer> {
	
	
}
