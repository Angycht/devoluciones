package com.devoluciones.services.mappers;

import com.devoluciones.persistence.entities.ProductoDevolucion;
import com.devoluciones.services.dtos.ProductoDevolucionInputDTO;
import com.devoluciones.services.dtos.ProductoDevolucionOutputDTO;

public class ProductoDevolucionMapper {
	
	public static ProductoDevolucionOutputDTO toDTO(ProductoDevolucion productoDevolucion) {
		ProductoDevolucionOutputDTO dto = new ProductoDevolucionOutputDTO();
		
		dto.setId(productoDevolucion.getId());
		dto.setIdProducto(productoDevolucion.getIdProducto());
		dto.setProducto(productoDevolucion.getProductos().getNombre());
		dto.setPrecio(productoDevolucion.getProductos().getPrecio());
		dto.setTiendaNombre(productoDevolucion.getProductos().getTiendaNombre());
		dto.setFechaCompra(productoDevolucion.getProductos().getFechaCompra());
		
		return dto;
	}
	
	public static ProductoDevolucion toEntity(ProductoDevolucionInputDTO dto) {
		ProductoDevolucion pd = new ProductoDevolucion();
		
		pd.setId(dto.getId());
		pd.setIdDevolucion(dto.getIdDevoluciones());
		pd.setIdProducto(dto.getIdProducto());
		
		return pd;
	}
}
