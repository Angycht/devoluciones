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

import com.devoluciones.persistence.entities.Transportista;
import com.devoluciones.services.TransportistaService;

@RestController
@RequestMapping("/transportistas")
public class TransportistaController {
	@Autowired
	private TransportistaService transportistaService;
	
	@GetMapping
	public ResponseEntity<List<Transportista>> listaTransportistas(){
		return ResponseEntity.ok(this.transportistaService.findAll());
	}
	
	@GetMapping("/{idTransportista}")
	public ResponseEntity<Transportista> getTransportistaId(@PathVariable int idTransportista){
		Optional<Transportista> transportista = this.transportistaService.findByid(idTransportista);
		if(transportista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(transportista.get());
	}
	
	@PostMapping
	public ResponseEntity<Transportista> crearUsuario(@RequestBody Transportista transportista){
		return new ResponseEntity<Transportista>(this.transportistaService.create(transportista), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idTransportista}")
	public ResponseEntity<Transportista> actualizarUsuario(@PathVariable int idTransportista, @RequestBody Transportista transportista){
		if(idTransportista != transportista.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.transportistaService.existeTransportista(idTransportista)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.transportistaService.save(transportista));
	}
	
	@DeleteMapping("/{idTransportista}")
	public ResponseEntity<Transportista> eliminarTransportista(@PathVariable int idTransportista){
		if(this.transportistaService.delete(idTransportista)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
