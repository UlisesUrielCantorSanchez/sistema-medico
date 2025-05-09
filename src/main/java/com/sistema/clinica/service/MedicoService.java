package com.sistema.clinica.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sistema.clinica.dto.MedicDTO;
import com.sistema.clinica.modelo.Medico;
import com.sistema.clinica.modelo.Persona;
import com.sistema.clinica.repository.MedicoRepository;
import com.sistema.clinica.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicoService {
	
	private final MedicoRepository medicoRepository;
	private final PersonaRepository personaRepository ;
	
	@Transactional
	public Integer guaradarMedico(MedicDTO medicoDTO) {
		Persona persona = new Persona();
		persona.setNombres(medicoDTO.getNombres());
		persona.setApellidoPaterno(medicoDTO.getApellidoPaterno());
		persona.setApellidoPaterno(medicoDTO.getApellidoMaterno());
		
		Integer idPersona = personaRepository.save(persona).getId();
		
		Medico medico = new Medico();
		medico.setIdEspecialidad(medicoDTO.getIdEspecialidad());
		medico.setIdPersona(idPersona);
		return medicoRepository.save(medico).getId();
		
	}

}
