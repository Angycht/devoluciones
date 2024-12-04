package com.devoluciones.persistence.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Productos")
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
	
	@Column(name = "fecha_compra", nullable = false)
	private LocalDate fechaCompra;
	
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

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
