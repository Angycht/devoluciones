package com.devoluciones.persistence.entities;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "producto")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "tienda_nombre", length = 100, nullable = false)
	private String tiendaNombre;
	
	@Column(name = "tienda_direccion", length = 100, nullable = false)
	private String tiendaDireccion;
	
	@Column(columnDefinition = "Decimal(10,2)", nullable = false)
	private Double precio;
	
	@Column(name = "fecha_compra", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime fechaCompra;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, nullable = false)
	private Usuario usuario;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTiendaNombre() {
		return tiendaNombre;
	}
	public void setTiendaNombre(String tiendaNombre) {
		this.tiendaNombre = tiendaNombre;
	}
	public String getTiendaDireccion() {
		return tiendaDireccion;
	}
	public void setTiendaDireccion(String tiendaDireccion) {
		this.tiendaDireccion = tiendaDireccion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
