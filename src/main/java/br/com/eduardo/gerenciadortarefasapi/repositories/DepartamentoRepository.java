package br.com.eduardo.gerenciadortarefasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardo.gerenciadortarefasapi.entities.Departamento;

@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Long>{

}
