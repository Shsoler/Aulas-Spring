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

import br.com.sergio.exception.AlunoNaoEncontrado;
import br.com.sergio.model.Aluno;
import br.com.sergio.repositorio.AlunoRepositorio;

@RestController
@CrossOrigin("*")
public class AlunoController {
	private final AlunoRepositorio repositorio;
	
	public AlunoController(AlunoRepositorio repositorio) {
		this.repositorio =repositorio;
	}

	//listar
	@GetMapping("/aluno")
	List<Aluno> getAlunos(){
		return repositorio.findAll();
	}
	//procurar por id
	@GetMapping("/aluno/{id}")
	Aluno getAluno(@PathVariable long id) {
		return repositorio.findById(id).orElseThrow(() -> new AlunoNaoEncontrado("Aluno não encontrado id:"+id));
	}
	//adicionar Aluno
	@PostMapping("/aluno")
	Aluno salvarAluno(@RequestBody Aluno novoAluno) {
		return repositorio.save(novoAluno);
	}
	//atualizar aluno
	@PutMapping("/aluno")
	Aluno atualizarAluno(@RequestBody Aluno novoAluno) {
		return repositorio.findById(novoAluno.getId()).map(aluno ->{
		aluno.setData_nasc(novoAluno.getData_nasc());
		aluno.setNome(novoAluno.getNome());
		if(novoAluno.getMateria_id()!=null)
			aluno.setMateria_id(novoAluno.getMateria_id());
		return repositorio.save(aluno);
		}).orElseThrow(() -> new AlunoNaoEncontrado("Aluno não encontrado id:"+novoAluno.getId()));
	}
	//deletar aluno
	@DeleteMapping("/aluno/{id}")
	void removerAluno(@PathVariable long id) {
		this.repositorio.deleteById(id);
	}
	
	
	
}
