package com.sistema.clinica.service;

import org.springframework.stereotype.Service;

import com.sistema.clinica.modelo.Consultorio;
import com.sistema.clinica.repository.ConsultorioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultorioService {
	
	private final ConsultorioRepository consultorioRepository;
	
	public Integer guardarConsultorio(Consultorio consultorio) {
		if(consultorioRepository.existsByNumeroConsultorio(consultorio.getNumeroConsultorio()) &&
				consultorioRepository.existsByPiso(consultorio.getPiso()))
		return 0;		
				else
		return consultorioRepository.save(consultorio).getId();
	}
	
	public void eliminarConsultorio(Integer idConsultorio) {
		consultorioRepository.deleteById(idConsultorio);
	}

}
