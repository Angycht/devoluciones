package com.devoluciones.services.dtos;

public class ProductoDevolucionOutputDTO {
	
	private Integer id;
	private Integer idProducto;
	private String producto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
}
