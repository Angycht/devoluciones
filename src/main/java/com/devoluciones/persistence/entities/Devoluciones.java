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
@Entity
@Table(name = "devoluciones")
@NoArgsConstructor
public class Devoluciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha_devolucion", nullable = false)
	private LocalDate fechaDevolucion;
	
	@Column(nullable = false)
	private Estado estado;
	
	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	private Double precio;
	
	@Column(name = "tamaño", length = 50)
	private String tamanio;
	
	@Column(columnDefinition = "DECIMAL(10,2)")
	private Double peso;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, nullable = false)
	private Productos producto;
	
	@ManyToOne
	@JoinColumn(name = "transportista_id", referencedColumnName = "id", insertable = false, nullable = false)
	private Transportista transportista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Transportista getTransportista() {
		return transportista;
	}

	public void setTransportista(Transportista transportista) {
		this.transportista = transportista;
	}

	
}
