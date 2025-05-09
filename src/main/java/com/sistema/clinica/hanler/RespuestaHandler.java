package com.sistema.clinica.hanler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespuestaHandler {
	
	private String mensaje = "Se ha producido un error en el Servidor";

	public static ResponseEntity<Object> generarRespuesta(String mensaje, HttpStatus estatus, Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Mensaje", mensaje); // Retorna el mensaje de la transaccion
		map.put("Estatus", estatus.value()); // Retorna el Codigo HTTP (200, 400, etc)
		map.put("Datos", obj); // Retorna los datos encontrados, modificados, etc.
		return new ResponseEntity<Object>(map, estatus);
	}

	public String getRespuesta() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
