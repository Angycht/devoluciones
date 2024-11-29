package com.devoluciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.Devoluciones;
import com.devoluciones.persistence.repositories.DevolucionesRepository;

@Service
public class DevolucionesService {
	@Autowired
	private DevolucionesRepository devolucionesRepository;
	
	//Devolvemos todas las devoluciones de la base de datos
	public List<Devoluciones> findAll(){
		return this.devolucionesRepository.findAll();
	}
	
	//Devolvemos si existe la devolucion que nos pasan
	public boolean existeDevoluciones(int idDevoluciones) {
		return this.devolucionesRepository.existsById(idDevoluciones);
	}
	
	//Devolvemos si existe la devolucion
	public Optional<Devoluciones> findByid(int idDevoluciones){
		return this.devolucionesRepository.findById(idDevoluciones);
	}
	
	//Creamos la devolucion
	public Devoluciones create(Devoluciones devoluciones) {
		return this.devolucionesRepository.save(devoluciones);
	}
	
	//Guardamos las devoluciones
	public Devoluciones save(Devoluciones devoluciones) {
		return this.devolucionesRepository.save(devoluciones);
	}
	
	//Eliminamos la devolucion
	public boolean delete(int idDevoluciones) {
		boolean result = false;
		if(this.devolucionesRepository.existsById(idDevoluciones)) {
			this.devolucionesRepository.deleteById(idDevoluciones);
			result = true;
		}
		return result;
	}
}
