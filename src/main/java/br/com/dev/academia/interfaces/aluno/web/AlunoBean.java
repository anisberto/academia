package br.com.dev.academia.interfaces.aluno.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.dev.academia.domain.aluno.Aluno;

@Named
@RequestScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public void carregar() {
		System.out.println("Estou carregando.....");
	}

	public String gravar() {
		System.out.println("Dados do Aluno: \n" + this.aluno.toString());
		return null;
	}
}
