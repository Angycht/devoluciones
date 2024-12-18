package com.devoluciones.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "producto_devolucion")
@NoArgsConstructor
public class ProductoDevolucion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "devolucion_id")
	private Integer idDevolucion;
	
	@Column(name = "producto_id")
	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name = "devolucion_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Devoluciones devolucion;
	
	@ManyToOne
	@JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Productos producto;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdDevolucion() {
		return idDevolucion;
	}
	public void setIdDevolucion(Integer idDevolucion) {
		this.idDevolucion = idDevolucion;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Devoluciones getDevoluciones() {
		return devolucion;
	}
	public void setDevoluciones(Devoluciones devoluciones) {
		this.devolucion = devoluciones;
	}
	public Productos getProductos() {
		return producto;
	}
	public void setProductos(Productos productos) {
		this.producto = productos;
	}
	
	
	
}
