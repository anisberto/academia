package br.com.dev.academia.interfaces.relatorio.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dev.academia.application.service.AlunoService;
import br.com.dev.academia.domain.acesso.Acesso;
import br.com.dev.academia.domain.aluno.Aluno;

@Named
@RequestScoped
public class RelatorioEntradaSaidaBean implements Serializable {

	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;

	private List<Acesso> acessos;

	private String matricula;

	private LocalDate dataInicial;

	private LocalDate dataFinal;

	public List<Acesso> gerarRelatorio() {
		try {
			acessos = alunoService.listAcessosAluno(matricula, dataInicial, dataFinal);
		} catch (Exception e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}
		return null;
	}

	public List<Aluno> carregarAluno() {
		return null;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

}
