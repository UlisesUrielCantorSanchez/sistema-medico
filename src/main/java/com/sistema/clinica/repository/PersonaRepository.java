package com.sistema.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.clinica.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
