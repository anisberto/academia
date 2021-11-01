package br.com.dev.academia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dev.academia.application.service.AlunoService;
import br.com.dev.academia.domain.aluno.Aluno;

@Named
@SessionScoped
public class PesquisaAlunoBean implements Serializable {

	@EJB
	private AlunoService alunoService;

	@Inject
	@RequestParameterMap
	private Map<String, String> requestParam;;

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

	public void check() {
		String parametro = requestParam.get("clear");
		if (parametro != null && Boolean.valueOf(parametro)) {
			matricula = null;
			nome = null;
			rg = null;
			telefone = null;
			alunos = null;
		}
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
