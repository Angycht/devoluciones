package com.devoluciones.services.dtos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductoDevolucionInputDTO {
	
	private Integer id;
	private Integer idDevoluciones;
	private Integer idProducto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdDevoluciones() {
		return idDevoluciones;
	}
	public void setIdDevoluciones(Integer idDevoluciones) {
		this.idDevoluciones = idDevoluciones;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
