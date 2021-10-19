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

	public Aluno create(Aluno aluno) throws Exception {
		entityManager.persist(aluno);
		Aluno alunoSalvo = entityManager.find(Aluno.class, aluno.getMatricula());

		if (alunoSalvo == null)
			throw new Exception("Não Foi possivel salvar o aluno");

		return alunoSalvo;
	}

	public Aluno update(Aluno aluno) throws Exception {
		entityManager.merge(aluno);
		Aluno alunoUpdate = entityManager.find(Aluno.class, aluno.getMatricula());

		if (alunoUpdate == null)
			throw new Exception("Não Foi possivel salvar o aluno");

		return alunoUpdate;

	}

	public Aluno findByMatricula(String matricula) throws Exception {
		Aluno alunoSearch = entityManager.find(Aluno.class, matricula);
		if (alunoSearch == null)
			throw new Exception("Não Foi possivel encontrar o aluno");

		return alunoSearch;
	}

	public List<Aluno> read() throws Exception {
		List<Aluno> listAluno = entityManager.createQuery("SELECT a FROM Aluno a ORDER BY a.nome", Aluno.class)
				.getResultList();
		if (listAluno.isEmpty())
			throw new Exception("Não foram encontrados alunos");

		return listAluno;

	}

	public void delete(String matricula) throws Exception {
		Aluno alunoSearch = entityManager.find(Aluno.class, matricula);
		if (alunoSearch == null)
			throw new Exception("Não Foi encontrado este aluno");

		entityManager.remove(alunoSearch);

	}

	public String getMaxMatriculaAno() {
		return entityManager
				.createQuery("SELECT MAX(a.matricula) FROM Aluno a WHERE a.matricula LIKE :ano", String.class)
				.setParameter("ano", Year.now() + "%").getSingleResult();
	}

}
