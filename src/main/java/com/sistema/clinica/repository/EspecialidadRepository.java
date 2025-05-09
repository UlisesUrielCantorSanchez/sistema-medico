package com.sistema.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.clinica.modelo.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	
	 boolean existsByNombre(String nombre);
	 
	 boolean existsByClave(String clave);

}
