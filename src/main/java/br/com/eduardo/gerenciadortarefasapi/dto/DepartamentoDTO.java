package br.com.eduardo.gerenciadortarefasapi.dto;

import java.io.Serializable;

import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;

public class DepartamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	
	public DepartamentoDTO() {}

	public DepartamentoDTO(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
	public DepartamentoDTO(Departamento entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
