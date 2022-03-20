package br.com.eduardo.gerenciadortarefasapi.services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eduardo.gerenciadortarefasapi.dto.TarefaDTO;
import br.com.eduardo.gerenciadortarefasapi.entities.Tarefa;
import br.com.eduardo.gerenciadortarefasapi.repositories.TarefaRepository;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.DatabaseException;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.ResourceNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public Page<TarefaDTO> findAll(Pageable pageable) {
		Page<Tarefa> list = repository.findAll(pageable);
		return list.map(m -> new TarefaDTO(m));
		
	}

	public TarefaDTO findById(Long id) {
		Optional<Tarefa> optional = repository.findById(id);
		Tarefa departamento = optional.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado."));
		return new TarefaDTO(departamento);
		
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
	
	@Transactional
	public TarefaDTO insert(TarefaDTO dto) {
		Tarefa entity = new Tarefa();
		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setPrazo(dto.getPrazo());
		entity.setDepartamento(dto.getDepartamento());
		entity.setDuracao(dto.getDuracao());
		entity.setPessoa(dto.getPessoa());
		entity.setSituacao(dto.getSituacao());
		entity = repository.save(entity);
		return new TarefaDTO(entity);
	}
	
	@Transactional
	public TarefaDTO update(Long id, TarefaDTO dto) {
		Tarefa entity = repository.getById(id);
		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setPrazo(dto.getPrazo());
		entity.setDepartamento(dto.getDepartamento());
		entity.setDuracao(dto.getDuracao());
		entity.setPessoa(dto.getPessoa());
		entity.setSituacao(dto.getSituacao());
		entity = repository.save(entity);
		return new TarefaDTO(entity);
	}

}
