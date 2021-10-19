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

		try {
			aluno.gerarMatricula(alunoRepository.getMaxMatriculaAno());
			return alunoRepository.create(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Aluno update(Aluno aluno) throws Exception {
		try {
			return alunoRepository.update(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Aluno findByMatricula(String matricula) throws Exception {
		try {
			return alunoRepository.findByMatricula(matricula);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Aluno> read() throws Exception {
		try {
			return alunoRepository.read();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public void delete(String matricula) throws Exception {
		try {
			alunoRepository.delete(matricula);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
