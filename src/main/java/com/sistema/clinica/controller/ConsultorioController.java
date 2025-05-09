package com.sistema.clinica.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.clinica.hanler.RespuestaHandler;
import com.sistema.clinica.modelo.Consultorio;
import com.sistema.clinica.modelo.Especialidad;
import com.sistema.clinica.service.ConsultorioService;
import com.sistema.clinica.service.EspecialidadService;
import com.sistema.clinica.utility.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/consultorio")
@RequiredArgsConstructor
public class ConsultorioController {
	
	private final ConsultorioService consultorioService;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarEspecialidad(@Valid @RequestBody Consultorio consultorio) {
		try {
			Integer id = consultorioService.guardarConsultorio(consultorio);		
			if(id == 0)
				return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.OK, "El registro ya existe.");
			else	
				return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, id);
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}
	
	@DeleteMapping("/borrar")
	public ResponseEntity<Object> eliminarEspecialidad(@Valid @RequestParam Integer idConsultorio) {
		try {
			consultorioService.eliminarConsultorio(idConsultorio);
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, null);
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}

}
