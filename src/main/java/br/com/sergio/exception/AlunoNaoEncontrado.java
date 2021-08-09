package br.com.sergio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNaoEncontrado extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontrado(String mensagem){
		super(mensagem);
	}

}
