package com.devoluciones.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.Usuario;

public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer> {

}
