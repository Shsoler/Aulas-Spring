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

import br.com.sergio.exception.MateriaNaoEncontrada;
import br.com.sergio.model.Aluno;
import br.com.sergio.model.Materia;
import br.com.sergio.repositorio.MateriaRepositorio;

@RestController
@CrossOrigin("*")
public class MateriaController {

	private final MateriaRepositorio repositorio;
	
	public MateriaController(MateriaRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	//listar materia
	@GetMapping("/materia")
	List<Materia> getMaterias(){
		return repositorio.findAll();
	}
	
	//procurar materia
	@GetMapping("/materia/{id}")
	Materia getMateria(@PathVariable long id) {
		return repositorio.findById(id).orElseThrow(()->new MateriaNaoEncontrada("materia não encontrada id:"+id));
	}
	//adicionar materia
	@PostMapping("/materia")
	Materia adicionarMateria(@RequestBody Materia novaMateria) {
		return repositorio.save(novaMateria);
	}
	//atualizar materia
	@PutMapping("/materia")
	Materia atualizarMateria(@RequestBody Materia novaMateria) {
		return repositorio.findById(novaMateria.getId()).map(materia -> {
			materia.setTitulo(novaMateria.getTitulo());
			if(novaMateria.getProfessor()!=null)
				materia.setProfessor(novaMateria.getProfessor());
			return repositorio.save(materia);
		}).orElseThrow(() -> new MateriaNaoEncontrada("Materia para atualizar não encontrada id:"+novaMateria.getId()));
	}
	//deletar materia
	@DeleteMapping("/materia/{id}")
	void deletarMateria(@PathVariable long id) {
		repositorio.deleteById(id);
	}
	
	//pegar alunos dentro da materia (substituir por inner join?)
	@GetMapping("/materia/{id}/alunos")
	List<Aluno> listarAlunos(@PathVariable long id){
		return repositorio.findById(id).map(materia -> materia.getAlunos()).orElseThrow(() -> new MateriaNaoEncontrada("Materia não encontrada id:"+id));
	}
}
