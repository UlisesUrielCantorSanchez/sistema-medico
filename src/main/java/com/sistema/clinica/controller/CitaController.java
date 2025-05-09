package com.sistema.clinica.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.clinica.hanler.RespuestaHandler;
import com.sistema.clinica.modelo.Cita;
import com.sistema.clinica.modelo.Consultorio;
import com.sistema.clinica.service.CitaService;
import com.sistema.clinica.service.ConsultorioService;
import com.sistema.clinica.utility.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cita")
@RequiredArgsConstructor
public class CitaController {
	
	private final CitaService citaService; 
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarCita(@Valid @RequestBody Cita cita) {
		try {
			Integer id = citaService.guardarCita(cita);		
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, id);
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}

}
