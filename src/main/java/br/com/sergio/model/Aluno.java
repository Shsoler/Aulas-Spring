package br.com.sergio.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;

	private String nome;
	
	@JsonDeserialize()
	private LocalDate data_nasc;
	
	@ManyToOne
	private Materia materia_id;
	
	public Aluno() {
		
	}
	
	public Aluno(long id, String nome, LocalDate data_nasc, Materia materia_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.materia_id = materia_id;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Materia getMateria_id() {
		return materia_id;
	}

	public void setMateria_id(Materia materia_id) {
		this.materia_id = materia_id;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", data_nasc=" + data_nasc + ", materia_id=" + materia_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_nasc == null) ? 0 : data_nasc.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Aluno other = (Aluno) obj;
		if (data_nasc == null) {
			if (other.data_nasc != null)
				return false;
		} else if (!data_nasc.equals(other.data_nasc))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
