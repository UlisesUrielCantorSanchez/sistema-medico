package com.sistema.clinica.service;

import org.springframework.stereotype.Service;

import com.sistema.clinica.dto.PacienteDTO;
import com.sistema.clinica.modelo.Paciente;
import com.sistema.clinica.modelo.Persona;
import com.sistema.clinica.repository.PacienteRepository;
import com.sistema.clinica.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {
	
	private final PacienteRepository pacienteRepository;
	private final PersonaRepository personaRepository ;
	
	
	public void guardarPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = new Paciente();
		
		Persona persona = new Persona();
		persona.setNombres(pacienteDTO.getNombres());
		persona.setApellidoPaterno(pacienteDTO.getApellidoPaterno());
		persona.setApellidoPaterno(pacienteDTO.getApellidoMaterno());
		
		Integer idPersona = personaRepository.save(persona).getId();
		
		paciente.setEmil(pacienteDTO.getEmail());
		paciente.setTelefono(pacienteDTO.getTelefono());
		paciente.setIdPersona(idPersona);
		
		pacienteRepository.save(paciente);
	}

}
