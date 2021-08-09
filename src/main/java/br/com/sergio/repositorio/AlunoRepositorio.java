package br.com.sergio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.model.Aluno;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Long>{

}
