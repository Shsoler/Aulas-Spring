package br.com.sergio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergio.exception.ProfessorNaoEncontrado;
import br.com.sergio.model.Professor;
import br.com.sergio.repositorio.ProfessorRepositorio;

@RestController
@CrossOrigin("*")
public class ProfessorController {

	private final ProfessorRepositorio repositorio;
	
	public ProfessorController(ProfessorRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	//listar professores
	@GetMapping("/professor")
	List<Professor> getProfessores(){
		return repositorio.findAll();
	}
	//pegar professor por id
	@GetMapping("/professor/{id}")
	Professor getProfessor(@PathVariable long id) {
		return repositorio.findById(id).orElseThrow(()-> new ProfessorNaoEncontrado("professor não encontrado id:"+id));
	}
	//adicionar professor
	@PostMapping("/professor")
	Professor salvarProfessor(@RequestBody Professor novoProfessor) {
		return repositorio.save(novoProfessor);
	}
	//atualizar professor
	@PutMapping("/professor")
	Professor atualizarProfessor(@RequestBody Professor novoProfessor) {
		return repositorio.findById(novoProfessor.getId()).map(professor ->{
			professor.setNome(novoProfessor.getNome());
			return repositorio.save(professor);
		}).orElseThrow(() -> new ProfessorNaoEncontrado("professor não encontrado atualização falha id:"+novoProfessor.getId()));
	}
	
	//deletar professor
	@DeleteMapping("/professor/{id}")
	void deletarProfessor(@PathVariable long id) {
		repositorio.deleteById(id);
	}
	
	
}
