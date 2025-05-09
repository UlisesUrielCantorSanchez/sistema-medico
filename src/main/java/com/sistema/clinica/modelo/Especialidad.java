package com.sistema.clinica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "especialidad", schema = "area")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column @NotNull 
	@NotBlank(message = "El nombre no debe estar en blanco")
	private String nombre;
	
	@Column @NotNull @NotBlank
	private String clave;
	
	@Column @NotNull @NotBlank
	@Size(max = 1555, message = "La descripción no debe superar los 555 caracteres")
	private String descripcion;

}
