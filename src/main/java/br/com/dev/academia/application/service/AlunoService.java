package br.com.dev.academia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.dev.academia.domain.aluno.Aluno;
import br.com.dev.academia.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {

	@EJB
	AlunoRepository alunoRepository;

	public Aluno create(Aluno aluno) {

		aluno.gerarMatricula(alunoRepository.getMaxMatriculaAno());
		return alunoRepository.create(aluno);

	}

	public Aluno update(Aluno aluno) {

		return alunoRepository.update(aluno);

	}

	public Aluno findByMatricula(String matricula) {

		return alunoRepository.findByMatricula(matricula);

	}

	public List<Aluno> read() {
		return alunoRepository.read();
	}

	public void delete(String matricula) {

		alunoRepository.delete(matricula);
	}

	public void createOrUpdate(Aluno aluno) {

		if (aluno.getMatricula().isEmpty()) {
			create(aluno);
		} else {
			update(aluno);
		}
	}

}
