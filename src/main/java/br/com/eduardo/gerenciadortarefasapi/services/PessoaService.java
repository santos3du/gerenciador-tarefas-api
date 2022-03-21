package br.com.eduardo.gerenciadortarefasapi.services;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eduardo.gerenciadortarefasapi.dto.PessoaDTO;
import br.com.eduardo.gerenciadortarefasapi.entities.Pessoa;
import br.com.eduardo.gerenciadortarefasapi.repositories.PessoaRepository;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.DatabaseException;
import br.com.eduardo.gerenciadortarefasapi.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Page<PessoaDTO> findAll(Pageable pageable) {
		Page<Pessoa> list = repository.findAll(pageable);
		return list.map(p -> new PessoaDTO(p));
		
	}

	public PessoaDTO findById(Long id) {
		Optional<Pessoa> optional = repository.findById(id);
		Pessoa entity = optional.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado."));
		return new PessoaDTO(entity, entity.getTarefas());
		
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
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		entity.setNome(dto.getNome());
		entity.setDepartamento(dto.getDepartamento());
		entity = repository.save(entity);
		return new PessoaDTO(entity);
	}
	
	@Transactional
	public PessoaDTO update(Long id, PessoaDTO dto) {
		Pessoa entity = repository.getOne(id);
		entity.setNome(dto.getNome());
		entity.setDepartamento(dto.getDepartamento());
		entity = repository.save(entity);
		return new PessoaDTO(entity);
	}

}
