package br.com.eduardo.gerenciadortarefasapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import br.com.eduardo.gerenciadortarefasapi.dto.DepartamentoDTO;
import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.repositories.DepartamentoRepository;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.DatabaseException;
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
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado. " + id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violarion");
		}
		
	}

	public DepartamentoDTO insert(DepartamentoDTO dto) {
		Departamento entity = new Departamento();
		entity.setTitulo(dto.getTitulo());
		entity = repository.save(entity);
		return new DepartamentoDTO(entity);
	}

}
