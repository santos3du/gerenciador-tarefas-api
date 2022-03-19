package br.com.eduardo.gerenciadortarefasapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eduardo.gerenciadortarefasapi.dto.DepartamentoDTO;
import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.repositories.DepartamentoRepository;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.ResourceNotFoundException;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	public Page<DepartamentoDTO> findAll(Pageable pageable) {
		Page<Departamento> list = repository.findAll(pageable);
		return list.map(m -> new DepartamentoDTO(m));
		
	}

	public DepartamentoDTO findById(Long id) {
		Optional<Departamento> optional = repository.findById(id);
		Departamento departamento = optional.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado."));
		return new DepartamentoDTO(departamento);
		
	}

}
