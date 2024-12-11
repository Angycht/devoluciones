package com.devoluciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.Productos;
import com.devoluciones.persistence.repositories.ProductoRepository;



@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	//Devolvemos todos los productos de la base de datos
	public List<Productos> findAll(){
		return this.productoRepository.findAll();
	}
	
	//Devolvemos si existe o no el producto introducido
	public boolean existsProducto(int idProducto) {
		return this.productoRepository.existsById(idProducto);
	}
	
	//Opcional para devolver el producto que nos pasen 
	public Optional<Productos> findById(int idProducto){
		return this.productoRepository.findById(idProducto);
	}
	
	//Creamos un nuevo producto
	public Productos create(Productos producto) {
		return this.productoRepository.save(producto);
	}
	
	//Guardamos el producto
	public Productos save(Productos productos) {
		return this.productoRepository.save(productos);
	}
	
	//Comprobamos que exista el producto y lo eliminamos
	public boolean delete(int idProducto) {
		boolean result = false;
		
		if(this.productoRepository.existsById(idProducto)) {
			this.productoRepository.deleteById(idProducto);
			result = true;
		}
		
		return result;
	}

	
}
