package com.devoluciones.persistence.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "fecha_devolucion", nullable = false,columnDefinition = "DATETIME")
	private LocalDateTime fechaDevolucion;
	
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
	@JoinColumn(name = "transportista_id", referencedColumnName = "id", insertable = false, nullable = false)
	private Transportista transportista;
	
	@OneToMany(mappedBy = "devolucion")
	@JsonIgnore
	private List<ProductoDevolucion> productoDevolucion;
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
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
	public Transportista getTransportista() {
		return transportista;
	}
	public void setTransportista(Transportista transportista) {
		this.transportista = transportista;
	}
	public List<ProductoDevolucion> getProductoDevolucion() {
		return productoDevolucion;
	}
	public void setProductoDevolucion(List<ProductoDevolucion> productoDevolucion) {
		this.productoDevolucion = productoDevolucion;
	}
	
}
