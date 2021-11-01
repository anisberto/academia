package br.com.dev.academia.domain.aluno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.dev.academia.application.util.StringUtils;
import br.com.dev.academia.domain.acesso.Acesso;
import br.com.dev.academia.domain.aluno.Aluno.Situacao;

@Stateless
public class AlunoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Aluno create(Aluno aluno) {
		entityManager.persist(aluno);
		Aluno alunoSalvo = entityManager.find(Aluno.class, aluno.getMatricula());

		return alunoSalvo;
	}

	public Aluno update(Aluno aluno) {
		entityManager.merge(aluno);
		Aluno alunoUpdate = entityManager.find(Aluno.class, aluno.getMatricula());

		return alunoUpdate;

	}

	public Aluno findByMatricula(String matricula) {
		Aluno alunoSearch = entityManager.find(Aluno.class, matricula);

		return alunoSearch;
	}

	public Aluno findByRg(Integer rg) {
		try {
			Aluno alunoSearch = entityManager.createQuery("SELECT a FROM Aluno a WHERE a.rg = :rg", Aluno.class)
					.setParameter("rg", rg).getSingleResult();

			return alunoSearch;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Aluno> read() {
		List<Aluno> listAluno = entityManager.createQuery("SELECT a FROM Aluno a ORDER BY a.nome", Aluno.class)
				.getResultList();

		return listAluno;

	}

	public void delete(String matricula) {
		entityManager.remove(findByMatricula(matricula));
	}

	public String getMaxMatriculaAno() {
		return entityManager
				.createQuery("SELECT MAX(a.matricula) FROM Aluno a WHERE a.matricula LIKE :ano", String.class)
				.setParameter("ano", Year.now() + "%").getSingleResult();
	}

	public List<Aluno> getAlunosBySituacao(Situacao situacao) {

		return entityManager
				.createQuery("SELECT a FROM Aluno a WHERE a.situacao = :situacao ORDER BY a.nome", Aluno.class)
				.setParameter("situacao", situacao).getResultList();
	}

	public List<Acesso> listAcessosAluno(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
		StringBuilder jpql = new StringBuilder("SELECT a FROM Acesso a WHERE ");

		if (!StringUtils.isEmpty(matricula)) {
			jpql.append(" a.aluno.matricula = :matricula AND ");
		}

		if (dataInicial != null) {
			jpql.append("a.entrada >= :entradaInicio AND ");
		}

		if (dataFinal != null) {
			jpql.append("a.saida <= :saidaFim AND ");
		}

		jpql.append("1 = 1 ORDER BY a.entrada");

		TypedQuery<Acesso> resultAcessos = entityManager.createQuery(jpql.toString(), Acesso.class);

		if (!StringUtils.isEmpty(matricula)) {
			resultAcessos.setParameter("matricula", matricula);
		}

		if (dataInicial != null) {
			LocalDateTime localCompare = LocalDateTime.of(dataInicial, LocalTime.of(0, 0, 0));
			resultAcessos.setParameter("entradaInicio", localCompare);

		}

		if (dataFinal != null) {
			LocalDateTime localCompareFim = LocalDateTime.of(dataFinal, LocalTime.of(23, 59, 59));
			resultAcessos.setParameter("saidaFim", localCompareFim);
			
		}

		return resultAcessos.getResultList();
	}

}
