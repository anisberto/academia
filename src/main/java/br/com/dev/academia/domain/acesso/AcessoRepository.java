package br.com.dev.academia.domain.acesso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dev.academia.domain.aluno.Aluno;

@Stateless
public class AcessoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Acesso ultimoAcesso(Aluno aluno) {

		try {
			return entityManager
					.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER BY a.id DESC",
							Acesso.class)
					.setParameter("matricula", aluno.getMatricula()).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void store(Acesso acesso) {
		entityManager.persist(acesso);
	}

}
