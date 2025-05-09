package com.sistema.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.clinica.modelo.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
