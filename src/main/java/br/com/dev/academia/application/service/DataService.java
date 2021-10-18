package br.com.dev.academia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.dev.academia.domain.aluno.Estado;
import br.com.dev.academia.domain.aluno.EstadoRepository;
import br.com.dev.academia.domain.aluno.Aluno.Sexo;
import br.com.dev.academia.domain.aluno.Aluno.Situacao;

@Stateless
public class DataService {
	
	@EJB
	private EstadoRepository estadoRepository;

	public Sexo[] getSexos() {
		return Sexo.values();
	}

	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
	
	public List<Estado> listEstados(){
		return estadoRepository.listEstados();
	}

}
