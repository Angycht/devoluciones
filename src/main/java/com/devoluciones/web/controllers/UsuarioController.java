package com.devoluciones.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devoluciones.persistence.entities.Usuario;
import com.devoluciones.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		return ResponseEntity.ok(this.usuarioService.findAll());
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable int idUsuario){
		Optional<Usuario> usuario = this.usuarioService.findByid(idUsuario);
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(this.usuarioService.create(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idUsuario}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int idUsuario,@RequestBody Usuario usuario){
		if(idUsuario != usuario.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.usuarioService.exitsUsuario(idUsuario)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.usuarioService.save(usuario));
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int idUsuario){
		if(this.usuarioService.delete(idUsuario)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
