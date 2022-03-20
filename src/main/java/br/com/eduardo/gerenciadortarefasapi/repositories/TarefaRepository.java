package br.com.eduardo.gerenciadortarefasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardo.gerenciadortarefasapi.entities.Tarefa;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Long>{

}
