package br.com.sergio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProfessorNaoEncontrado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorNaoEncontrado(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
