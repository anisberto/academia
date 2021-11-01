package br.com.dev.academia.application.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.picketbox.util.StringUtil;

import br.com.dev.academia.application.util.Validation;
import br.com.dev.academia.application.util.ValidationException;
import br.com.dev.academia.domain.acesso.Acesso;
import br.com.dev.academia.domain.aluno.Aluno;
import br.com.dev.academia.domain.aluno.Aluno.Situacao;
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

	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone) {
		List<Aluno> lista = new ArrayList<Aluno>();
		lista.add(alunoRepository.findByMatricula(matricula));
		return lista;
	}

	public List<Aluno> getAlunoSituacao(Situacao situacao) {
		Validation.assertNotEmpty(situacao);
		return alunoRepository.getAlunosBySituacao(situacao);
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

	public List<Acesso> listAcessosAluno(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
//		if (StringUtil.isNotNull(matricula) && dataInicial == null && dataFinal == null) {
//			throw new ValidationException("Informe pelo menos dois criterios para busca!");
//		}
		return alunoRepository.listAcessosAluno(matricula, dataInicial, dataFinal);
	}
}
