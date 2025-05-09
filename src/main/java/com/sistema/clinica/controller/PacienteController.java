package com.sistema.clinica.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.clinica.dto.PacienteDTO;
import com.sistema.clinica.hanler.RespuestaHandler;
import com.sistema.clinica.modelo.Cita;
import com.sistema.clinica.service.MedicoService;
import com.sistema.clinica.service.PacienteService;
import com.sistema.clinica.utility.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/paciente")
@RequiredArgsConstructor
public class PacienteController {
	
	private final PacienteService pacienteService;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarPaciente(@RequestBody PacienteDTO pacienteDTO) {
		try {
			pacienteService.guardarPaciente(pacienteDTO);		
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, null);
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}

}
