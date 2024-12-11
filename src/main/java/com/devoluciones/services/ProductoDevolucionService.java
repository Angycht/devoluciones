package com.devoluciones.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.ProductoDevolucion;
import com.devoluciones.persistence.repositories.ProductoDevolucionRepository;
import com.devoluciones.services.dtos.ProductoDevolucionOutputDTO;
import com.devoluciones.services.mappers.ProductoDevolucionMapper;
@Service
public class ProductoDevolucionService {
	@Autowired
	private ProductoDevolucionRepository productoDevolucionRepository;
	
	public List<ProductoDevolucion> findAll(){
		return this.productoDevolucionRepository.findAll();
	}
	
	public boolean existeProductoDevolucion(int idProductoDevolucion) {
		return this.productoDevolucionRepository.existsById(idProductoDevolucion);
	}
	
	public Optional<ProductoDevolucion> findById(int idProductoDevolucion){
		return this.productoDevolucionRepository.findById(idProductoDevolucion);
	}
	
	public ProductoDevolucion create(ProductoDevolucion productoDevolucion) {
		return this.productoDevolucionRepository.save(productoDevolucion);
	}
	
	public ProductoDevolucion save(ProductoDevolucion productoDevolucion) {
		return this.productoDevolucionRepository.save(productoDevolucion);
	}
	
	public boolean delete(int idProductoDevolucion) {
		boolean result = false;
		
		if(this.productoDevolucionRepository.existsById(idProductoDevolucion)) {
			this.productoDevolucionRepository.deleteById(idProductoDevolucion);
			result = true;
		}
		
		return result;
	}
	
	public List<ProductoDevolucionOutputDTO> findByIdProducto(int idProducto){
		List<ProductoDevolucionOutputDTO> dtos = new ArrayList<ProductoDevolucionOutputDTO>();
		
		for(ProductoDevolucion pd : this.productoDevolucionRepository.findByIdProducto(idProducto)) {
			dtos.add(ProductoDevolucionMapper.toDTO(pd));
		}
		return dtos;
	}
	
}
