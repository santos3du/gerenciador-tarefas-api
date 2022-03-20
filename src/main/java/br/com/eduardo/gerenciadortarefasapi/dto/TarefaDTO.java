package br.com.eduardo.gerenciadortarefasapi.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;
import br.com.eduardo.gerenciadortarefasapi.entities.Pessoa;
import br.com.eduardo.gerenciadortarefasapi.entities.Tarefa;
import br.com.eduardo.gerenciadortarefasapi.entities.enums.Situacao;

public class TarefaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	private Instant prazo;
	private Departamento departamento;
	private int duracao;
	private Pessoa pessoa;
	private Situacao situacao;
	
	public TarefaDTO() {}

	public TarefaDTO(Long id, String titulo, String descricao, Instant prazo, Departamento departamento, int duracao,
			Pessoa pessoa, Situacao situacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.departamento = departamento;
		this.duracao = duracao;
		this.pessoa = pessoa;
		this.situacao = situacao;
	}
	
	public TarefaDTO(Tarefa entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.prazo = entity.getPrazo();
		this.departamento = entity.getDepartamento();
		this.duracao = entity.getDuracao();
		this.pessoa = entity.getPessoa();
		this.situacao = entity.getSituacao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getPrazo() {
		return prazo;
	}

	public void setPrazo(Instant prazo) {
		this.prazo = prazo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	

}
