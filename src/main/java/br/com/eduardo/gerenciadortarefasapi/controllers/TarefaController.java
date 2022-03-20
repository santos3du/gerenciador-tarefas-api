package br.com.eduardo.gerenciadortarefasapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eduardo.gerenciadortarefasapi.dto.TarefaDTO;
import br.com.eduardo.gerenciadortarefasapi.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<Page<TarefaDTO>> findAll(Pageable pageable) {
		Page<TarefaDTO> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Long id) {
		TarefaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaDTO> update(@PathVariable Long id, @RequestBody TarefaDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
