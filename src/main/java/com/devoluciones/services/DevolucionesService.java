package com.devoluciones.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoluciones.persistence.entities.Devoluciones;
import com.devoluciones.persistence.repositories.DevolucionesRepository;
import com.devoluciones.services.dtos.DevolucionesDTO;
import com.devoluciones.services.mappers.DevolucionesMapper;

@Service
public class DevolucionesService {
	@Autowired
	private DevolucionesRepository devolucionesRepository;
	
	//Devolvemos todas las devoluciones de la base de datos
	public List<DevolucionesDTO> findAll(){
		List<DevolucionesDTO> devolucionesDTO = new ArrayList<DevolucionesDTO>();
		
		for(Devoluciones d : this.devolucionesRepository.findAll()) {
			devolucionesDTO.add(DevolucionesMapper.toDto(d));
		}
		
		return devolucionesDTO;
	}
	
	//Devolvemos si existe la devolucion que nos pasan
	public boolean existeDevoluciones(int idDevoluciones) {
		return this.devolucionesRepository.existsById(idDevoluciones);
	}
	
	//Devolvemos si existe la devolucion
	public DevolucionesDTO findByid(int idDevoluciones){
		return DevolucionesMapper.toDto(this.devolucionesRepository.findById(idDevoluciones).get());
	}
	
	//Creamos la devolucion
	public Devoluciones create(Devoluciones devoluciones) {
		devoluciones.setFechaDevolucion(LocalDateTime.now());
		devoluciones.setPrecio(0.0);
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
