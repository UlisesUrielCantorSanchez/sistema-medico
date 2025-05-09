package com.sistema.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.clinica.modelo.Consultorio;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer>{
	
     boolean existsByNumeroConsultorio(Integer numeroConsultorio);
     
     boolean existsByPiso(Integer piso);
}
