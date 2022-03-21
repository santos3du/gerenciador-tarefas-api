package br.com.eduardo.gerenciadortarefasapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.entities.Pessoa;
import br.com.eduardo.gerenciadortarefasapi.entities.Tarefa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Departamento departamento;
	private List<Tarefa> tarefas = new ArrayList<>();
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
		this.tarefas = entity.getTarefas();
	}
	
	public PessoaDTO(Pessoa entity, List<Tarefa> tarefas) {
		this(entity);
		this.tarefas = tarefas;
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

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
}
