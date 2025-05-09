package com.sistema.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.clinica.modelo.Cita;

public interface CitaReposiotry extends JpaRepository<Cita, Integer>{
	
	
	@Transactional(readOnly = true)
	@Query(value = """
			SELECT COUNT(c) FROM puclic.Cita c 
			WHERE c.idMedico = :idMedico 
			AND DATE(c.fecha) = CURRENT_DATE AND c.borrado = false
			""", nativeQuery = true)
	Integer contarCitasDeHoyPorMedico(@Param("idMedico") Integer idMedico);
	

}
