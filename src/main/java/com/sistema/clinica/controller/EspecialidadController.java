package com.sistema.clinica.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.clinica.hanler.RespuestaHandler;
import com.sistema.clinica.modelo.Especialidad;
import com.sistema.clinica.service.EspecialidadService;
import com.sistema.clinica.utility.Constants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/especialidad")
@RequiredArgsConstructor
public class EspecialidadController {
	
	private final EspecialidadService especialidadService; 
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarEspecialidad(@Valid @RequestBody Especialidad especialidad) {
		try {
			Integer id = especialidadService.guardarEspecialidad(especialidad);		
			if(id == 0)
				return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.OK, "No puedes repetir los nombres o claves.");
			else	
				return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, id);
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Object> listarEspecialidad() {
		try {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, especialidadService.listarEspecialidades());
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}
	
	@GetMapping("/borrar")
	public ResponseEntity<Object> borrarEspecialidad() {
		try {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_EXITO, HttpStatus.OK, especialidadService.listarEspecialidades());
		} catch (Exception e) {
			return RespuestaHandler.generarRespuesta(Constants.RESPUESTA_ERROR_SERVIDOR, HttpStatus.NOT_FOUND, e.getMessage());		
		} 
	}
	

}
