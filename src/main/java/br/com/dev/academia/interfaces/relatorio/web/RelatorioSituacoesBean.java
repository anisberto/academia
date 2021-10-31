package br.com.dev.academia.interfaces.relatorio.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.dev.academia.application.service.AlunoService;
import br.com.dev.academia.domain.aluno.Aluno;
import br.com.dev.academia.domain.aluno.Aluno.Situacao;

@Named
@SessionScoped
public class RelatorioSituacoesBean implements Serializable {

	private Situacao situacao;
	
	@EJB
	private AlunoService alunoService;

	private List<Aluno> alunos;

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Aluno> gerarRelatorio() {
		this.alunos = alunoService.getAlunoSituacao(situacao);
		return null;
	}

	public void check() {

	}

}
