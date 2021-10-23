package br.com.dev.academia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.dev.academia.application.service.AlunoService;
import br.com.dev.academia.domain.aluno.Aluno;

@Named
@SessionScoped
public class PesquisaAlunoBean implements Serializable {

	@EJB
	private AlunoService alunoService;

	private Aluno aluno = new Aluno();
	private String matricula;
	private String check;
	private String nome;
	private Integer rg;
	private Integer telefone;
	private List<Aluno> alunos;

	public String pesquisar() {
		this.alunos = alunoService.listAlunos(matricula, nome, rg, telefone);
		List<Aluno> alunoSearch = alunoService.listAlunos(matricula, nome, rg, telefone);
		return null;
	}

	public String excluir(String matricula) {
		alunoService.delete(matricula);
		return pesquisar();
	}

	public String check() {
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public AlunoService getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
