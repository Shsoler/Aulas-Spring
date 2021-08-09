package br.com.sergio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.model.Professor;

@Repository
public interface ProfessorRepositorio extends JpaRepository<Professor, Long>{

}
