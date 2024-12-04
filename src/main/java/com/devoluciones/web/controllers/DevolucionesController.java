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

import com.devoluciones.persistence.entities.Devoluciones;
import com.devoluciones.services.DevolucionesService;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionesController {
	@Autowired
	private DevolucionesService devolucionesService;
	
	@GetMapping
	public ResponseEntity<List<Devoluciones>> listaDevoluciones(){
		return ResponseEntity.ok(this.devolucionesService.findAll());
	}
	
	@GetMapping("/{idDevoluciones}")
	public ResponseEntity<Devoluciones> getDevolucionesId(@PathVariable int idDevoluciones){
		Optional<Devoluciones> devoluciones = this.devolucionesService.findByid(idDevoluciones);
		if(devoluciones.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(devoluciones.get());
	}
	
	@PostMapping
	public ResponseEntity<Devoluciones> crearDevolucion(@RequestBody Devoluciones devoluciones){
		return new ResponseEntity<Devoluciones>(this.devolucionesService.create(devoluciones), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idDevoluciones}")
	public ResponseEntity<Devoluciones> actualizarDevoluciones(@PathVariable int idDevoluciones, @RequestBody Devoluciones devoluciones){
		if(idDevoluciones != devoluciones.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.devolucionesService.existeDevoluciones(idDevoluciones)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.devolucionesService.save(devoluciones));
	}
	
	@DeleteMapping("/{idDevoluciones}")
	public ResponseEntity<Devoluciones> eliminarDevoluciones(@PathVariable int idDevoluciones){
		if(this.devolucionesService.delete(idDevoluciones)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
