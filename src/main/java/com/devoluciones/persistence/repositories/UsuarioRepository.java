package com.devoluciones.persistence.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.devoluciones.persistence.entities.Usuario;

public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer> {
	Optional<Usuario> findByCorreo(String correo);
}
