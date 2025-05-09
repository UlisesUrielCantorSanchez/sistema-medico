package com.sistema.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.clinica.modelo.Especialidad;
import com.sistema.clinica.repository.EspecialidadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspecialidadService {
	
	private final EspecialidadRepository especialidadRepository;
	
	public Integer guardarEspecialidad(Especialidad especialidad) {
		
		if(especialidadRepository.existsByNombre(especialidad.getNombre()) || 
		   especialidadRepository.existsByClave(especialidad.getClave()))
			return 0;		
		else
			return especialidadRepository.save(especialidad).getId();
	}
	
	public List<Especialidad> listarEspecialidades() {
		List<Especialidad> especialidades = especialidadRepository.findAll();
		return especialidades;
	}

}
