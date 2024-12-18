package com.devoluciones.services.dtos;

import java.time.LocalDateTime;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class ProductoDevolucionOutputDTO {
	
	private Integer id;
	private Integer idProducto;
	private String producto;
	private Double precio;
	private String tiendaNombre;
	private LocalDateTime fechaCompra;
	
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getTiendaNombre() {
		return tiendaNombre;
	}
	public void setTiendaNombre(String tiendaNombre) {
		this.tiendaNombre = tiendaNombre;
	}
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	
}
