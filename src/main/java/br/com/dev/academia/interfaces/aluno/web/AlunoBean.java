package br.com.dev.academia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.dev.academia.application.service.AlunoService;
import br.com.dev.academia.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable {

	@EJB
	private AlunoService alunoService;

	private String matricula;

	private boolean render = false;


	private Aluno aluno = new Aluno();
	private String titulo = "Cadastro de Aluno";

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public void carregar() {
		if (this.matricula != null) {
			System.out.println("ITem Parametro:... " + this.matricula);
			try {
				this.aluno = alunoService.findByMatricula(this.matricula);
				this.titulo = "Atualizando Aluno";
			} catch (Exception e) {
				// System.out.println(e.getMessage());
			}

		}
	}

	public String gravar() {
		System.out.println("Dados do Aluno: \n" + this.aluno.toString());
		alunoService.createOrUpdate(aluno);
		return aluno.getEmail();
	}
}
