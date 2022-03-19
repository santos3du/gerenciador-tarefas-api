package br.com.eduardo.gerenciadortarefasapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.gerenciadortarefasapi.dto.DepartamentoDTO;
import br.com.eduardo.gerenciadortarefasapi.services.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public ResponseEntity<Page<DepartamentoDTO>> findAll(Pageable pageable) {
		Page<DepartamentoDTO> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
		
	}

}
