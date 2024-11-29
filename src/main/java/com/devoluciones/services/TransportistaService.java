package com.devoluciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.Transportista;
import com.devoluciones.persistence.repositories.TransportistaRepository;

@Service
public class TransportistaService {
	@Autowired
	private TransportistaRepository transportistaRepository;
	
	//Devolvemos todos los transportistas de la base de datos
	public List<Transportista> findAll(){
		return this.transportistaRepository.findAll();
	}
	
	//Devolvemos si existe el transportista 
	public boolean existeTransportista(int idTransportista) {
		return this.transportistaRepository.existsById(idTransportista);
	}
	
	//Devolvemos si existe el transportista 
	public Optional<Transportista> findByid(int idTransportista){
		return this.transportistaRepository.findById(idTransportista);
	}
	
	//Guardamos el nuevo transportista creado
	public Transportista create(Transportista transportista) {
		return this.transportistaRepository.save(transportista);
	}
	
	//Guardamos los transportista
	public Transportista save(Transportista transportista) {
		return this.transportistaRepository.save(transportista);
	}
	
	//Eliminamos el transportista dado por el id 
	public boolean delete(int idTransportista) {
		boolean result = false;
		if(this.transportistaRepository.existsById(idTransportista)) {
			this.transportistaRepository.deleteById(idTransportista);
			result = true;
		}
		
		return result;
		
	}
}
