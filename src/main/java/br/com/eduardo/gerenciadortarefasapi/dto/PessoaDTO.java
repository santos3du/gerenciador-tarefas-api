package br.com.eduardo.gerenciadortarefasapi.dto;

import java.io.Serializable;

import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.entities.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Departamento departamento;
	
	public PessoaDTO() {}

	public PessoaDTO(Long id, String nome, Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.setDepartamento(departamento);
	}

	public PessoaDTO(Pessoa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.departamento = entity.getDepartamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
