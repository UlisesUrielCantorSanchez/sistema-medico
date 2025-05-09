package com.sistema.clinica.service;

import org.springframework.stereotype.Service;

import com.sistema.clinica.modelo.Persona;
import com.sistema.clinica.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {
	
	private PersonaRepository personaRepository;
	
	public Integer guardarMedico(Persona persona) {
		return personaRepository.save(persona).getId();
	}

}
