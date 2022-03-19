package br.com.eduardo.gerenciadortarefasapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eduardo.gerenciadortarefasapi.dto.DepartamentoDTO;
import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	public Page<DepartamentoDTO> findAll(Pageable pageable) {
		Page<Departamento> list = repository.findAll(pageable);
		return list.map(m -> new DepartamentoDTO(m));
		
	}

}
