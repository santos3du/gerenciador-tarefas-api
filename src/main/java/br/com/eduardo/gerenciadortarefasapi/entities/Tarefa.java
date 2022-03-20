package br.com.eduardo.gerenciadortarefasapi.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.eduardo.gerenciadortarefasapi.entities.enums.Situacao;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String descricao;
	private Instant prazo;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	private int duracao;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	private Situacao situacao;
	
	public Tarefa() {}

	public Tarefa(Long id, String titulo, String descricao, Instant prazo, Departamento departamento, int duracao,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarefa [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", prazo=");
		builder.append(prazo);
		builder.append(", departamento=");
		builder.append(departamento);
		builder.append(", duracao=");
		builder.append(duracao);
		builder.append(", pessoa=");
		builder.append(pessoa);
		builder.append(", situacao=");
		builder.append(situacao);
		builder.append("]");
		return builder.toString();
	}
	

}
