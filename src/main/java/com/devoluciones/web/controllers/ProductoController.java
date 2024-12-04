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

import com.devoluciones.persistence.entities.Productos;
import com.devoluciones.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Productos>> listaProductos(){
		return ResponseEntity.ok(this.productoService.findAll());
	}
	
	@GetMapping("/{idProductos}")
	public ResponseEntity<Productos> getProductosId(@PathVariable int idProductos){
		Optional<Productos> productos = this.productoService.findById(idProductos);
		if(productos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(productos.get());
	}
	
	@PostMapping
	public ResponseEntity<Productos> crearProductos(@RequestBody Productos productos){
		return new ResponseEntity<Productos>(this.productoService.create(productos), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idProductos}")
	public ResponseEntity<Productos> actualizarProductos(@PathVariable int idProductos, @RequestBody Productos productos){
		if(idProductos != productos.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.productoService.existsProducto(idProductos)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.productoService.save(productos));
	}
	
	@DeleteMapping("/{idProductos}")
	public ResponseEntity<Productos> eliminarProductos(@PathVariable int idProductos){
		if(this.productoService.delete(idProductos)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
