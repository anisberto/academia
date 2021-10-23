package br.com.dev.academia.domain.aluno;

import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
