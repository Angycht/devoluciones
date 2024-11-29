package com.devoluciones.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.Transportista;

public interface TransportistaRepository extends ListCrudRepository<Transportista, Integer> {

}
