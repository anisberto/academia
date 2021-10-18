package br.com.dev.academia.interfaces.shared.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.jboss.security.auth.spi.DatabaseServerLoginModule;

import br.com.dev.academia.application.service.DataService;
import br.com.dev.academia.domain.aluno.Estado;
import br.com.dev.academia.domain.aluno.Aluno.Sexo;
import br.com.dev.academia.domain.aluno.Aluno.Situacao;

@Named
@ApplicationScoped
public class DataBean implements Serializable {

	@EJB
	private DataService dataService;
	
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}

	public Situacao[] getSituacoes() {
		return dataService.getSituacoes();
	}

	public List<Estado> getEstados() {
		return dataService.listEstados();
	}
}
