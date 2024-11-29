package com.devoluciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.Usuario;
import com.devoluciones.persistence.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Devolvemos todos los usuarios de la base de datos
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	//Devolvemos si el usuario que nos pasa existe o no en la base de datos
	public boolean exitsUsuario (int idUsuario) {
		return this.usuarioRepository.existsById(idUsuario);
	}
	
	//Opcional para devolver el usuario que nos pasen
	public Optional<Usuario> findByid(int idUsuario){
		return this.usuarioRepository.findById(idUsuario);
	}
	
	// Guardamos el nuevo usuario que se ha creado
	public Usuario create(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	} 
	
	//Funcion para guardar el usuario
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	//Funcion para comprobar si existe el usuario y si es así se elimina
	public boolean delete (int idUsuario) {
		boolean result = false;
		if(this.usuarioRepository.existsById(idUsuario)) {
			this.usuarioRepository.deleteById(idUsuario);
			result = true;
		}
		return result;
	}
	
	
}
