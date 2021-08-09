package br.com.sergio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.model.Materia;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia,Long>{

}
