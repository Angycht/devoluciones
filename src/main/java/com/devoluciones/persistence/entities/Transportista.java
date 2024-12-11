package com.devoluciones.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transportista")
public class Transportista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "precio_base", columnDefinition = "DECIMAL(10,2)")
	private Double precioBase;

	@OneToMany(mappedBy = "transportista")
	@JsonIgnore
	private List<Devoluciones> devoluciones;
	
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
	public Double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	
	
}
