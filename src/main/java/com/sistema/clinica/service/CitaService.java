package com.sistema.clinica.service;

import org.springframework.stereotype.Service;

import com.sistema.clinica.modelo.Cita;
import com.sistema.clinica.repository.CitaReposiotry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaService {
	
	private final CitaReposiotry citaReposiotry;
	
	public Integer guardarCita(Cita cita) {
		 long totalHoy = citaReposiotry.contarCitasDeHoyPorMedico(cita.getIdMedico());

		    if (totalHoy >= 8) {
		        throw new IllegalStateException("El médico ya tiene 8 citas para hoy");
		    }
		    return citaReposiotry.save(cita).getId();	    		
	}
	
	

}
