package com.devoluciones.services.mappers;
/*
import java.util.ArrayList;
import java.util.List;*/

import java.util.ArrayList;
import java.util.List;

import com.devoluciones.persistence.entities.Devoluciones;
import com.devoluciones.persistence.entities.ProductoDevolucion;
import com.devoluciones.services.dtos.DevolucionesDTO;
import com.devoluciones.services.dtos.ProductoDevolucionOutputDTO;

public class DevolucionesMapper {
	public static DevolucionesDTO toDto(Devoluciones devoluciones) {
		DevolucionesDTO dto = new DevolucionesDTO();
		
		dto.setId(devoluciones.getId());
		dto.setFecha(devoluciones.getFechaDevolucion());
		dto.setEstado(devoluciones.getEstado());
		dto.setTamanio(devoluciones.getTamanio());
		dto.setPeso(devoluciones.getPeso());
		
		dto.setCliente(devoluciones.getUsuario().getNombre() + " " + devoluciones.getUsuario().getApellidos());
		dto.setTelefono(devoluciones.getUsuario().getTelefono());
		dto.setCorreo(devoluciones.getUsuario().getCorreo());
		dto.setDireccion(devoluciones.getUsuario().getDireccion());
		
		dto.setTransportista(devoluciones.getTransportista().getNombre());
		
		List<ProductoDevolucionOutputDTO> productos = new ArrayList<ProductoDevolucionOutputDTO>();
	
		for(ProductoDevolucion pd : devoluciones.getProductoDevolucion()) {
			productos.add(ProductoDevolucionMapper.toDTO(pd));
		}
		
		dto.setProducto(productos);
		
		return dto;
	}
}
